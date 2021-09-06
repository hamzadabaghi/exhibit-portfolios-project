package portfolio.services;

import java.util.List;

import portfolio.entities.Portfolio;

public interface PortfolioService {

	public List<Portfolio> getAllPortfolio();

	public Portfolio getPortfolio(Long iduser);

	public Portfolio createPortfolio(Portfolio portfolio);

	public void deletePortfolio(Long id_portfolio);

}
