package it.object.tempolibero.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "view")
public class View {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "idMedia")
	@JsonIdentityReference(alwaysAsId = true)
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
}
