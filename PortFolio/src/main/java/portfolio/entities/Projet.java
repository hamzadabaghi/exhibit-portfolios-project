package portfolio.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Projet {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_projet;
	private Long id_portfolio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_debut;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_fin;
	
	private String description_projet;
	private String liens_projet;
	private String titre_projet;

	
}