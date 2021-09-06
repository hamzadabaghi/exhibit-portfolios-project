package portfolio.services;

import java.util.List;
import portfolio.entities.Projet;

public interface ProjetService {

	public List<Projet> getAllProjetUser(Long id);

	public void createProjet(Projet Projet);

	public void deleteProjet(Long id_Projet);

}
