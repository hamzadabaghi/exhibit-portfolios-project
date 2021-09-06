package portfolio.web.appControllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import portfolio.entities.Formation;
import portfolio.entities.Portfolio;
import portfolio.services.FormationService;
import portfolio.services.PortfolioService;
import portfolio.services.ProfilePicturesService;
import portfolio.entities.AppUser;
import portfolio.entities.Certificat;
import portfolio.services.AccountService;
import portfolio.services.CertificatService;
import portfolio.services.DomaineService;
import portfolio.entities.Projet;
import portfolio.services.ProjetService;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {

	@Autowired
	private FormationService formationService;

	@Autowired
	private DomaineService domaineService;

	@Autowired
	private PortfolioService portfolioService;

	@Autowired
	private CertificatService certificatService;

	@Autowired
	private ProjetService projetService;

	@Autowired
	ProfilePicturesService pictureService;

	@Autowired
	private AccountService accountService;

	@Autowired
	Map<String, Object> model;

	private AppUser getAuthenticatedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}
		String currentPrincipalName = authentication.getName();
		return accountService.findUserByUsername(currentPrincipalName);
	}

	@GetMapping("/add")
	public ModelAndView getAllFormation() {

		String viewName = "PAGES/form";

		model.clear();
		/* model.put("formation",new Formation()); */
		Map<String, Object> a = new HashMap<>();
		a.put("authenticatedUser", getAuthenticatedUser());
		a.put("portfolio", new Portfolio());
		a.put("listeDomain", domaineService.getAllDomaine());
		return new ModelAndView(viewName, a);

	}

	@PostMapping("/create")
	public ModelAndView createFormation(Portfolio portfolio, @RequestParam Map<String, String> queryParams)
			throws ParseException {
		model.clear();

		Portfolio p = portfolioService.createPortfolio(portfolio);

		Long id = p.getId_portfolio();
		Long id_user = Long.parseLong(queryParams.get("id_user"));
		p.setId_user(id_user);
		p.setDescription_portfolio(queryParams.get("description_portfolio"));
		p.setLinkedin_profil(queryParams.get("linkedin_profil"));
		p.setNum_telephone(queryParams.get("num_telephone"));
		p.setDomaine(queryParams.get("domaine"));

		int x = 0, y = 0, z = 0;
		String s = queryParams.get("x");
		String s2 = queryParams.get("y");
		String s3 = queryParams.get("z");
		if (s != null) {
			x = Integer.parseInt(s);
		}
		if (s2 != null) {
			y = Integer.parseInt(s2);
		}
		if (s3 != null) {
			z = Integer.parseInt(s3);
		}

		for (int i = 0; i <= x; i++) {
			Formation formation2 = new Formation();
			formation2.setTitre_formation(queryParams.get("titre_formation" + i));
			formation2.setLieu_formation(queryParams.get("lieu_formation" + i));
			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = parser.parse(queryParams.get("date_debut_formation" + i));
			formation2.setDate_debut_formation(date1);
			Date date2 = parser.parse(queryParams.get("date_fin_formation" + i));
			formation2.setDate_fin_formation(date2);
			formation2.setDescription_formation(queryParams.get("description_formation" + i));
			formation2.setId_portfolio(id);
			formationService.createFormation(formation2);
		}

		for (int i = 0; i <= y; i++) {
			Certificat certificat = new Certificat();
			certificat.setTitre_certificat(queryParams.get("titre_certificat" + i));
			certificat.setOrganisation_certificat(queryParams.get("organisation_certificat" + i));
			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = parser.parse(queryParams.get("date_debut_certificat" + i));
			certificat.setDate_debut_certificat(date1);
			Date date2 = parser.parse(queryParams.get("date_expiration_certificat" + i));
			certificat.setDate_expiration_certificat(date2);
			certificat.setCode_certificat(queryParams.get("code_certificat" + i));
			certificat.setDescription_certificat(queryParams.get("Description_certificat" + i));
			certificat.setId_portfolio(id);
			certificatService.createCertificat(certificat);
		}

		for (int i = 0; i <= z; i++) {
			Projet projet = new Projet();
			projet.setTitre_projet(queryParams.get("titre_projet" + i));
			projet.setLiens_projet(queryParams.get("liens_projet" + i));
			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = parser.parse(queryParams.get("date_debut" + i));
			projet.setDate_debut(date1);
			Date date2 = parser.parse(queryParams.get("date_fin" + i));
			projet.setDate_fin(date2);
			projet.setDescription_projet(queryParams.get("description_projet" + i));
			projet.setId_portfolio(id);
			projetService.createProjet(projet);
		}

		RedirectView redirect = new RedirectView();
		redirect.setUrl("/portfolio/showport");
		return new ModelAndView(redirect);
	}

	@GetMapping("/showport")
	public ModelAndView getPortfolio() {

		model.clear();

		if (getAuthenticatedUser() == null) {
			return new ModelAndView("PAGES/login", model);
		}
		model.put("picturePortfolio", pictureService.loadPictureUser(getAuthenticatedUser().getId()));

		model.put("authUserID", getAuthenticatedUser().getId());
		model.put("userPortfolio", getAuthenticatedUser());
		if (portfolioService.getPortfolio(getAuthenticatedUser().getId()) == null) {
			return new ModelAndView("PAGES/noportfolio", model);
		}
		Portfolio p = portfolioService.getPortfolio(getAuthenticatedUser().getId());

		Long idTheme = p.getId_theme();
		String viewName = "PAGES/theme" + idTheme;
		Long id = p.getId_portfolio();
		List<Formation> ListFormation = formationService.getAllFormationPortfolio(id);
		List<Projet> ListProjet = projetService.getAllProjetUser(id);
		List<Certificat> ListCertificat = certificatService.getAllCertificatsPortfolio(id);

		model.put("portfolio", p);
		model.put("listeFormation", ListFormation);

		model.put("listeProjet", ListProjet);
		model.put("listeCertificat", ListCertificat);

		return new ModelAndView(viewName, model);

	}

	@GetMapping("/showUsersPortfolio")
	public ModelAndView getUsersPortfolios(@RequestParam("username") String uname) {

		model.clear();

		AppUser userPrt = accountService.findUserByUsername(uname);

		model.put("picturePortfolio", pictureService.loadPictureUser(userPrt.getId()));
		model.put("userPortfolio", accountService.findUserByUsername(uname));

		if (getAuthenticatedUser() != null)
			model.put("authUserID", getAuthenticatedUser().getId());

		Portfolio p = portfolioService.getPortfolio(userPrt.getId());
		Long idTheme = p.getId_theme();
		String viewName = "PAGES/theme" + idTheme;
		Long idm = p.getId_portfolio();

		List<Formation> ListFormation = formationService.getAllFormationPortfolio(idm);
		List<Projet> ListProjet = projetService.getAllProjetUser(idm);
		List<Certificat> ListCertificat = certificatService.getAllCertificatsPortfolio(idm);

		if (ListFormation != null)
			model.put("listeFormation", ListFormation);

		if (ListProjet != null)
			model.put("listeProjet", ListProjet);

		if (ListCertificat != null)
			model.put("listeCertificat", ListCertificat);

		model.put("portfolio", p);

		return new ModelAndView(viewName, model);

	}

	@GetMapping("/update")
	public ModelAndView updatePortfolio() {
		String viewName = "PAGES/Update";

		model.clear();
		model.put("authenticatedUser", getAuthenticatedUser());
		Portfolio p = portfolioService.getPortfolio(getAuthenticatedUser().getId());
		Long id = p.getId_portfolio();
		List<Formation> ListFormation = formationService.getAllFormationPortfolio(id);
		List<Projet> ListProjet = projetService.getAllProjetUser(id);
		List<Certificat> ListCertificat = certificatService.getAllCertificatsPortfolio(id);
		model.put("portfolio", p);
		model.put("listeFormation", ListFormation);
		model.put("listeProjet", ListProjet);
		model.put("listeCertificat", ListCertificat);

		Projet projet = new Projet();
		model.put("projet2", projet);
		return new ModelAndView(viewName, model);
	}

}
