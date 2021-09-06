package portfolio.web.appControllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import portfolio.entities.AppUser;
import portfolio.entities.Domaine;
import portfolio.entities.Portfolio;
import portfolio.services.AccountService;
import portfolio.services.DomaineService;
import portfolio.services.PortfolioService;
import portfolio.services.ProfilePicturesService;
import portfolio.web.responses.UsernameJobPicture;

@Controller
public class AppController {

	@Autowired
	AccountService accountService;

	@Autowired
	PortfolioService portfolioService;

	@Autowired
	ProfilePicturesService pictureService;

	@Autowired
	DomaineService domaineService;

	@Autowired
	private Map<String, Object> model = new HashMap<String, Object>();

	@RequestMapping({ "/index", "/" })
	public ModelAndView getIndex() {
		String viewName = "index";

		/* list of users with their information and categories of the website */

		List<Portfolio> portflolios = portfolioService.getAllPortfolio();
		List<AppUser> allUsers = accountService.getAllUser();
		List<UsernameJobPicture> usersPortfolio = new ArrayList<UsernameJobPicture>();
		List<Domaine> domaines = domaineService.getAllDomaine();
		int numberOfMembers = allUsers.size();

		if (portflolios != null) {

			for (Portfolio portfolio : portflolios) {

				/* collect the data from users and pictures using the portfolio object */

				UsernameJobPicture newUser = new UsernameJobPicture();

				/* pictures */

				newUser.setImageUser(pictureService.loadPictureUser(portfolio.getId_user()));
				newUser.setIdUser(portfolio.getId_user());
				newUser.setIdPortfolio(portfolio.getId_portfolio());
				newUser.setCategory(portfolio.getDomaine());

				/* users */

				for (AppUser user : allUsers) {

					if (user.getId() == portfolio.getId_user()) {
						newUser.setJobUser(user.getJob());
						newUser.setFirstName(user.getFirstName());
						newUser.setLastName(user.getLastName());
						newUser.setUserName(user.getUsername());
						break;

					}
				}

				usersPortfolio.add(newUser);

			}

			model.put("portfolios", usersPortfolio);
			model.put("domaines", domaines);
			model.put("numberOfMembers", numberOfMembers);
			return new ModelAndView(viewName, model);

		}

		model.put("portfolios", null);
		model.put("domaines", null);
		model.put("numberOfMembers", numberOfMembers);

		return new ModelAndView(viewName, model);
	}

}
