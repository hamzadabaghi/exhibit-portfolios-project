package portfolio.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor

public class Portfolio {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_portfolio;
	
	private Long id_user;
	private String description_portfolio;
	private String linkedin_profil;
	private String num_telephone;
	private long id_theme;
	private String domaine;


	
	
}