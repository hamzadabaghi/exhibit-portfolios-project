package portfolio.seeders;


import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import portfolio.entities.Certificat;
import portfolio.entities.Formation;
import portfolio.entities.Portfolio;
import portfolio.entities.Projet;
import portfolio.repositories.CertificatRepository;
import portfolio.repositories.FormationRepository;
import portfolio.repositories.PortfolioRepository;
import portfolio.repositories.ProjetRepository;

@Component
public class PortfolioSeeder implements CommandLineRunner {

	@Autowired
	PortfolioRepository portfolioRepository;
	@Autowired
	CertificatRepository certificatRepository;
	@Autowired
	FormationRepository formationRepository;
	@Autowired
	ProjetRepository projetRepository;

	@Override
	public void run(String... args) throws Exception {

		/* creating */
		
		/* Development */
		
		/* Portfolio */
		
		Portfolio hamzaPortfolio =  portfolioRepository.save(new Portfolio(null, 1L, "hamzaPortfolio", "hamza.dabaghi@gmail.com", "+212612345678", 2, "Development"));
		
		/* certificates */
		
		certificatRepository.save(new Certificat(null,hamzaPortfolio.getId_portfolio(),"1234567",new Date(),new Date(),"Java EE certification ","Openclassrooms","Developper des sites web avec Java EE"));
		
		/* Formation */
		
		formationRepository.save(new Formation(null,hamzaPortfolio.getId_portfolio(),new Date(),new Date(),"Master Informatique","FST FES","SIR"));
		
		/* Project */
		
		projetRepository.save(new Projet(null,hamzaPortfolio.getId_portfolio(), new Date(),new Date(),"Realisation de une application web pour gerer les reunion RCP","","OCTOPUS"));
		
		
		/* Portfolio */
		
		Portfolio kawtharPortfolio = portfolioRepository.save(new Portfolio(null, 2L, "kawtharPortfolio", "kawthar.mssaidi@gmail.com", "+212612345678", 2, "Development"));
		
		/* certificates */
		
		certificatRepository.save(new Certificat(null,kawtharPortfolio.getId_portfolio(),"1234567",new Date(),new Date(),"Java EE certification ","Openclassrooms","Developper des sites web avec Java EE"));
		
		/* Formation */
		
		formationRepository.save(new Formation(null,kawtharPortfolio.getId_portfolio(),new Date(),new Date(),"Master Informatique","FST FES","SIR"));
		
		/* Project */
		
		projetRepository.save(new Projet(null,kawtharPortfolio.getId_portfolio(), new Date(),new Date(),"Realisation de une application web pour gerer les reunion RCP","","OCTOPUS"));
		
		
		/* Translation */

		/* Portfolio */
		
		Portfolio TheaPortfolio = portfolioRepository.save(new Portfolio(null, 3L, "TheaPortfolio", "Thea.Whittle@gmail.com", "+212612345678", 2, "Translation"));
		
		/* certificates */
		
		certificatRepository.save(new Certificat(null,TheaPortfolio.getId_portfolio(),"1234567",new Date(),new Date(),"Java EE certification ","Openclassrooms","Developper des sites web avec Java EE"));
		
		/* Formation */
		
		formationRepository.save(new Formation(null,TheaPortfolio.getId_portfolio(),new Date(),new Date(),"Master Informatique","FST FES","SIR"));
		
		/* Project */
		
		projetRepository.save(new Projet(null,TheaPortfolio.getId_portfolio(), new Date(),new Date(),"Realisation de une application web pour gerer les reunion RCP","","OCTOPUS"));
		
		
		
		/* Writing */
		
		/* Portfolio */
		
		Portfolio CathrynPortfolio = portfolioRepository.save(new Portfolio(null, 4L, "CathrynPortfolio", "Cathryn.Ferguson@gmail.com", "+212612345678", 2, "Writing"));
		
		/* certificates */
		
		certificatRepository.save(new Certificat(null,CathrynPortfolio.getId_portfolio(),"1234567",new Date(),new Date(),"Java EE certification ","Openclassrooms","Developper des sites web avec Java EE"));
		
		/* Formation */
		
		formationRepository.save(new Formation(null,CathrynPortfolio.getId_portfolio(),new Date(),new Date(),"Master Informatique","FST FES","SIR"));
		
		/* Project */
		
		projetRepository.save(new Projet(null,CathrynPortfolio.getId_portfolio(), new Date(),new Date(),"Realisation de une application web pour gerer les reunion RCP","","OCTOPUS"));
		
		
		/* Graphics */
		
		/* Portfolio */
		
		Portfolio RobertPortfolio = portfolioRepository.save(new Portfolio(null, 5L, "RobertPortfolio", "Robert.Pino@gmail.com", "+212612345678", 2, "Graphics"));
		
		/* certificates */
		
		certificatRepository.save(new Certificat(null,RobertPortfolio.getId_portfolio(),"1234567",new Date(),new Date(),"Java EE certification ","Openclassrooms","Developper des sites web avec Java EE"));
		
		/* Formation */
		
		formationRepository.save(new Formation(null,RobertPortfolio.getId_portfolio(),new Date(),new Date(),"Master Informatique","FST FES","SIR"));
		
		/* Project */
		
		projetRepository.save(new Projet(null,RobertPortfolio.getId_portfolio(), new Date(),new Date(),"Realisation de une application web pour gerer les reunion RCP","","OCTOPUS"));
		
		
		/* Finance */
		
		/* Portfolio */
		
		Portfolio KevinPortfolio = portfolioRepository.save(new Portfolio(null, 6L, "KevinPortfolio", "Kevin.Ingrassia@gmail.com", "+212612345678", 2, "Finance"));

		
		/* certificates */
		
		certificatRepository.save(new Certificat(null,KevinPortfolio.getId_portfolio(),"1234567",new Date(),new Date(),"Java EE certification ","Openclassrooms","Developper des sites web avec Java EE"));
		
		/* Formation */
		
		formationRepository.save(new Formation(null,KevinPortfolio.getId_portfolio(),new Date(),new Date(),"Master Informatique","FST FES","SIR"));
		
		/* Project */
		
		projetRepository.save(new Projet(null,KevinPortfolio.getId_portfolio(), new Date(),new Date(),"Realisation de une application web pour gerer les reunion RCP","","OCTOPUS"));
		
		

		
		/* Marketing */
		
		/* Portfolio */
		
		Portfolio ClayPortfolio = portfolioRepository.save(new Portfolio(null, 7L, "ClayPortfolio", "Clay.Bailey@gmail.com", "+212612345678", 2, "Marketing"));
		
		/* certificates */
		
		certificatRepository.save(new Certificat(null,ClayPortfolio.getId_portfolio(),"1234567",new Date(),new Date(),"Java EE certification ","Openclassrooms","Developper des sites web avec Java EE"));
		
		/* Formation */
		
		formationRepository.save(new Formation(null,ClayPortfolio.getId_portfolio(),new Date(),new Date(),"Master Informatique","FST FES","SIR"));
		
		/* Project */
		
		projetRepository.save(new Projet(null,ClayPortfolio.getId_portfolio(), new Date(),new Date(),"Realisation de une application web pour gerer les reunion RCP","","OCTOPUS"));
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
