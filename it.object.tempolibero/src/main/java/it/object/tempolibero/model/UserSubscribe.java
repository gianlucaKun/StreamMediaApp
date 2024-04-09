package it.object.tempolibero.model;

import java.util.Calendar;
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

@Entity
@Table(name = "userSubscription")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSubscribe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datainIzio, dataFine;

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
	@JoinColumn(name = "idSubscribe")
	private Subscribe subscribe;
	
	// Aggiungi questo campo per rappresentare solo l'ID
				@JsonProperty("id_user")
				public Long getsubscribeId() {
					return (subscribe != null) ? subscribe.getId() : null;
				}

				// Ignora il campo tesserato durante la serializzazione
				@JsonIgnore
				public Subscribe getsubscribe() {
					return subscribe;
				}

	@PrePersist
	protected void onCreate() {
		// Imposta la data inizio al momento della creazione del record
		this.datainIzio = new Date();

		// Calcola la data fine esattamente un anno dopo la data inizio
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.datainIzio);
		calendar.add(Calendar.YEAR, 1); // Aggiungi un anno
		this.dataFine = calendar.getTime();
	}
}
