package portfolio.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import portfolio.services.AccountService;
import portfolio.services.ProfilePicturesService;
import portfolio.entities.AppRole;
import portfolio.entities.AppUser;

@Component
public class UsersSeeder implements CommandLineRunner{

	@Autowired
	AccountService accountService;
	
	@Autowired
	ProfilePicturesService pictureService;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		/* users me and my workmate */
		
		AppUser hamza = accountService.saveUser(new AppUser(null,"hamza","Hamza","Dabaghi","hamza.dabaghi@gmail.com","Fez Soukayna 2012","Fez","Morocco","30000","Software Engineering Student","1234",null));
		
		AppUser kawthar = accountService.saveUser(new AppUser(null,"kawthar","Kawthar","Mssiaidi","kawthar.mssiaidi@gmail.com","Meknes 2012","Meknes","Morocco","30002","Software Engineering Student","1234",null));
		
		/* users of test */
		
		/* Translation woman*/
		
		AppUser Thea = accountService.saveUser(new AppUser(null,"Thea","Thea","Whittle","Thea.Whittle@gmail.com","3765  Frederick Street","Mcclellan","USA","30000","Translator","1234",null));
		
		/* Writing woman */
		
		AppUser Cathryn = accountService.saveUser(new AppUser(null,"Cathryn","Cathryn","Ferguson","Cathryn.Ferguson@gmail.com","3765  Frederick Street","Mcclellan","USA","30000","Writer","1234",null));
		
		/* Graphics man */
		
		AppUser Robert = accountService.saveUser(new AppUser(null,"Robert","Robert","Pino","Robert.Pino@gmail.com","3765  Frederick Street","Mcclellan","USA","30000","Designer","1234",null));
		
		/* Finance man */
		
		AppUser Kevin = accountService.saveUser(new AppUser(null,"Kevin","Kevin","Ingrassia","Kevin.Ingrassia@gmail.com","3765  Frederick Street","Mcclellan","USA","30000","Accountant","1234",null));
		
		/* Marketing man */
		
		AppUser Clay = accountService.saveUser(new AppUser(null,"Clay","Clay","Bailey","Clay.Bailey@gmail.com","3765  Frederick Street","Mcclellan","USA","30000","Analyst","1234",null));
		
		
		
		/* roles */
		
		accountService.saveRole(new AppRole(null,"ROLE_ADMIN"));
		accountService.saveRole(new AppRole(null,"ROLE_USER"));

		
		/* Affectation Role*/ 
		
		accountService.addRoleToUser("hamza", "ROLE_ADMIN");
		accountService.addRoleToUser("kawthar", "ROLE_ADMIN");
		
		/* users Role */
		
		accountService.addRoleToUser("Thea", "ROLE_USER");
		accountService.addRoleToUser("Cathryn", "ROLE_USER");
		accountService.addRoleToUser("Robert", "ROLE_USER");
		accountService.addRoleToUser("Kevin", "ROLE_USER");
		accountService.addRoleToUser("Clay", "ROLE_USER");

		/* images */
		
		pictureService.saveImageToUser(hamza.getId(), "hamza.jpg");
		pictureService.saveImageToUser(kawthar.getId(), "kawthar.jpg");
		pictureService.saveImageToUser(Thea.getId(), "Traduction.jpg");
		pictureService.saveImageToUser(Cathryn.getId(), "Redaction.jpg");
		pictureService.saveImageToUser(Robert.getId(), "Graphisme.jpg");
		pictureService.saveImageToUser(Kevin.getId(), "Finance.jpg");
		pictureService.saveImageToUser(Clay.getId(), "Marketing.jpg");
		
		
		
		
		
	}
	
	

}
