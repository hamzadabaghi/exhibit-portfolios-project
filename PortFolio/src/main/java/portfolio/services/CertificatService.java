package portfolio.services;

import java.util.List;
import portfolio.entities.Certificat;

public interface CertificatService {

	public List<Certificat> getAllCertificatsPortfolio(Long id);

	public Certificat createCertificat(Certificat certificat);

	public void deleteCertificat(Long id_certificat);

}
