package portfolio.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Formation{

	
	 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_formation;
	private Long id_portfolio;
	
	@Column(nullable = true) @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_debut_formation;
	
	@Column(nullable = true) 	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_fin_formation;
	
	private String description_formation;
	private String lieu_formation;
	private String titre_formation;

	
}