package it.object.tempolibero.model;

import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.object.tempolibero.util.JpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements JpaEntity{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
//    private String country;
//    private String language;
    private String profilePicture;

    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastAccess;
    
    
    
    
    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;
    
 // Aggiungi questo campo per rappresentare solo l'ID
 			@JsonProperty("id_user")
 			public Long getRoleId() {
 				return (role != null) ? role.getId() : null;
 			}

 			// Ignora il campo tesserato durante la serializzazione
 			@JsonIgnore
 			public Role getRole() {
 				return role;
 			}
    
//    @OneToMany(mappedBy = "user")
//	private List<UserSubscribe> userSubscribe;
//    
//    @OneToMany(mappedBy = "user")
//   	private List<Media> media;
    
    
	@PrePersist
	protected void onCreate() {
		// Imposta la data al momento della creazione del record
		this.lastAccess = new Date();
	}

}
