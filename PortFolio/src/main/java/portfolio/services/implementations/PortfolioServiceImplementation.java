package portfolio.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.entities.Portfolio;
import portfolio.repositories.PortfolioRepository;
import portfolio.services.PortfolioService;

@Service("PortfolioService")
public class PortfolioServiceImplementation implements PortfolioService {

	@Autowired
	private PortfolioRepository PortfolioRepository;

	@Override
	public List<Portfolio> getAllPortfolio() {
		return PortfolioRepository.findAll();
	}

	@Override
	public Portfolio createPortfolio(Portfolio Portfolio) {
		return PortfolioRepository.save(Portfolio);
	}

	@Override
	public void deletePortfolio(Long id_Portfolio) {
		PortfolioRepository.deleteById(id_Portfolio);
	}

	@Override
	public Portfolio getPortfolio(Long iduser) {

		return PortfolioRepository.findPortfolioByIdUser(iduser);
	}

}
