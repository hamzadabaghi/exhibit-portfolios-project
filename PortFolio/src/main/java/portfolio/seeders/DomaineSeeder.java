package portfolio.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import portfolio.entities.Domaine;
import portfolio.repositories.DomaineRepository;

@Component
public class DomaineSeeder implements CommandLineRunner{

	@Autowired
	DomaineRepository domaineRepository;
	
	
	
	
	@Override
	public void run(String... args) throws Exception {

		domaineRepository.save(new Domaine(null,"Marketing"));

		domaineRepository.save(new Domaine(null,"Development"));
		
		domaineRepository.save(new Domaine(null,"Graphics"));
		
		domaineRepository.save(new Domaine(null,"Writing"));
		
		domaineRepository.save(new Domaine(null,"Translation"));
		
		domaineRepository.save(new Domaine(null,"Finance"));
	
	}

}
