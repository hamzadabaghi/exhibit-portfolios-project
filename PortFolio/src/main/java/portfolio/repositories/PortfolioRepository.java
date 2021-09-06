package portfolio.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import portfolio.entities.Portfolio;


@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio,Long> {

	@Query(value="SELECT * FROM portfolio WHERE id_user = :iduser",nativeQuery=true)
	Portfolio findPortfolioByIdUser (@Param("iduser") Long iduser);
	
}
