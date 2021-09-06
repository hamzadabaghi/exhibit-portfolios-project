package portfolio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class ProfilePictures {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImage;
	private Long userId;
	private String imageProfile = "default.jpg";
	
}
