package portfolio.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.entities.Formation;
import portfolio.repositories.FormationRepository;
import portfolio.services.FormationService;

@Service
public class FormationServiceImpl  implements FormationService{

	@Autowired
	FormationRepository formationRepository;
	

	@Override
	public void createFormation(Formation formation) {	
		formationRepository.save(formation);	
	}

	@Override
	public void deleteFormation(Long id_formation) {
		formationRepository.deleteById(id_formation);
	}

	@Override
	public List<Formation> getAllFormationPortfolio(Long id) {
		
		return formationRepository.findFormationByIdPortfolio(id);
	}

}
