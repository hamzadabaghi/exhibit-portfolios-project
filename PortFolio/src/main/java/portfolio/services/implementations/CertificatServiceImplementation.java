package portfolio.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.entities.Certificat;
import portfolio.repositories.CertificatRepository;
import portfolio.services.CertificatService;

@Service("CertificatService")
public class CertificatServiceImplementation implements CertificatService {

	@Autowired
	private CertificatRepository certificatRepository;

	@Override
	public Certificat createCertificat(Certificat Certificat) {
		return certificatRepository.save(Certificat);
	}

	@Override
	public void deleteCertificat(Long id_Certificat) {
		certificatRepository.deleteById(id_Certificat);
	}

	@Override
	public List<Certificat> getAllCertificatsPortfolio(Long id) {

		return certificatRepository.findCertificatByIdPortfolio(id);
	}

}
