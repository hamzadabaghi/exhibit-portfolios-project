package portfolio.repositories;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import portfolio.entities.Projet;


@Repository
public interface ProjetRepository extends JpaRepository<Projet,Long> {
	/* HQL */
	@Query(value="SELECT * FROM projet WHERE id_portfolio = :idportfolio",nativeQuery=true)
	List<Projet> findProjetByIdPortfolio (@Param("idportfolio") Long idportfolio);
	
	@Query(value="UPDATE projet SET titre_projet=:titre,date_debut=:db , date_fin=:df,description_projet=:desc,liens_projet=:lien WHERE id_projet=:idpro",nativeQuery=true)
	void updateProjet (@Param("titre") String titre,@Param("db") Date db,@Param("df") Date df,@Param("desc") String desc,@Param("lien") String lien,@Param("idpro") Long idpro);
}
