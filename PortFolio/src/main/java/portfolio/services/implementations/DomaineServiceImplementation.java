package portfolio.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.entities.Domaine;
import portfolio.repositories.DomaineRepository;
import portfolio.services.DomaineService;

@Service
public class DomaineServiceImplementation implements DomaineService {

	@Autowired
	DomaineRepository domainenRepository;

	@Override
	public List<Domaine> getAllDomaine() {
		return domainenRepository.findAll();
	}
}
