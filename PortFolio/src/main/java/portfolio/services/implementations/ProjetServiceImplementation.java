package portfolio.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.entities.Projet;
import portfolio.repositories.ProjetRepository;
import portfolio.services.ProjetService;

@Service("ProjetService")
public class ProjetServiceImplementation implements ProjetService {

	@Autowired
	private ProjetRepository projetRepository;

	@Override
	public void createProjet(Projet Projet) {
		projetRepository.save(Projet);
	}

	@Override
	public void deleteProjet(Long id_Projet) {
		projetRepository.deleteById(id_Projet);
	}

	@Override
	public List<Projet> getAllProjetUser(Long id) {
		return projetRepository.findProjetByIdPortfolio(id);
	}

}
