package it.object.tempolibero.model;

import java.util.Date;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	@JoinColumn(name = "idMedia")
	private Media media;

	// Aggiungi questo campo per rappresentare solo l'ID
	@JsonProperty("id_media")
	public Long getMediaId() {
		return (media != null) ? media.getId() : null;
	}

	// Ignora il campo tesserato durante la serializzazione
	@JsonIgnore
	public Media getMedia() {
		return media;
	}

	private String text;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@PrePersist
	protected void onCreate() {
		// Imposta la data al momento della creazione del record
		this.date = new Date();
	}
}