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

public class Certificat {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_certificat;
	private Long id_portfolio;
	private String code_certificat;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_debut_certificat;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_expiration_certificat;
	private String Description_certificat;
	private String organisation_certificat;
	private String titre_certificat;

	

}