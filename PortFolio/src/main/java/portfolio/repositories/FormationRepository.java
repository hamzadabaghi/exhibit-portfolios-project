package portfolio.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import portfolio.entities.Formation;



@Repository
public interface FormationRepository extends JpaRepository<Formation,Long> {
	
	@Query(value="SELECT * FROM formation WHERE id_portfolio = :idportfolio",nativeQuery=true)
	List<Formation> findFormationByIdPortfolio (@Param("idportfolio") Long idportfolio);
}
