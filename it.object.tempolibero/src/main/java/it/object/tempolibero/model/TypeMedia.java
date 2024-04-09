package it.object.tempolibero.model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "typeMedia")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeMedia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String type;
	
//	 @OneToMany(mappedBy = "typeMedia")
//	   	private List<Media> media;
}
