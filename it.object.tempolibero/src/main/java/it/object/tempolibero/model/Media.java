package it.object.tempolibero.model;

import java.sql.Time;
import java.util.Date;

import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "media")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Media {

	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataCaricamento;
	
	@TimeZoneStorage(TimeZoneStorageType.AUTO)
	private Time duration;
	
	private String title;
	private String nomeAllaCazzoDiCane;
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	
	// Aggiungi questo campo per rappresentare solo l'ID
			@JsonProperty("id_user")
			public Long getUserId() {
				return (user != null) ? user.getId() : null;
			}

			// Ignora il campo tesserato durante la serializzazione
			@JsonIgnore
			public User getUser() {
				return user;
			}

	
	@ManyToOne
	@JoinColumn(name = "idType")
	private TypeMedia typeMedia;
	
	// Aggiungi questo campo per rappresentare solo l'ID
		@JsonProperty("id_media")
		public Long getTypeMediaId() {
			return (typeMedia != null) ? typeMedia.getId() : null;
		}

		// Ignora il campo tesserato durante la serializzazione
		@JsonIgnore
		public TypeMedia getTypeMedia() {
			return typeMedia;
		}

	
	@PrePersist
	protected void onCreate() {
		// Imposta la data al momento della creazione del record
		this.dataCaricamento = new Date();
	}
}
