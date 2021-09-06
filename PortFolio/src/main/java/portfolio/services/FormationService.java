package portfolio.services;

import java.util.List;
import portfolio.entities.Formation;

public interface FormationService {

	public List<Formation> getAllFormationPortfolio(Long id);

	public void createFormation(Formation formation);

	public void deleteFormation(Long id_formation);

}
