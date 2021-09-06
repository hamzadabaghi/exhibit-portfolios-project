package portfolio.web.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UsernameJobPicture {

	/* class to show the collected data */
	
	private Long idPortfolio;
	private String firstName;
	private String lastName;
	private String jobUser;
	private Long idUser;
	private String imageUser;
	private String category;
	private String userName;
	
	
	
}
