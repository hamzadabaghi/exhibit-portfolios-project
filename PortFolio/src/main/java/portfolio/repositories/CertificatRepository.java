package portfolio.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import portfolio.entities.Certificat;

@Repository
public interface CertificatRepository extends JpaRepository<Certificat,Long> {
	/* HQL */
	@Query(value="SELECT * FROM certificat WHERE id_portfolio = :idportfolio",nativeQuery=true)
	List<Certificat> findCertificatByIdPortfolio (@Param("idportfolio") Long idportfolio);
}
