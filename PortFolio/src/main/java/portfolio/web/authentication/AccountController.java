package portfolio.web.authentication;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import portfolio.entities.AppUser;
import portfolio.entities.Certificat;
import portfolio.entities.Formation;
import portfolio.entities.Portfolio;
import portfolio.entities.Projet;
import portfolio.services.AccountService;
import portfolio.services.CertificatService;
import portfolio.services.FormationService;
import portfolio.services.PortfolioService;
import portfolio.services.ProfilePicturesService;
import portfolio.services.ProjetService;
import portfolio.web.requests.LoginRequest;
import portfolio.web.requests.RegisterRequest;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PortfolioService portfolioService;

	@Autowired
	FormationService formationService;

	@Autowired
	CertificatService certificatService;

	@Autowired
	ProjetService projetService;

	@Autowired
	private Map<String, Object> model = new HashMap<String, Object>();

	@Autowired
	ProfilePicturesService profilePictures;

	/* for alert if the profile is updated */
	private static boolean AlertUpdateProfile = false;

	/* for alert if the account is well created */

	private static boolean AlertCreateAccount = false;

	@PostMapping("/register")
	public ModelAndView register(RegisterRequest user) {

		if (!user.getPassword().equals(user.getRepassword()))
			throw new RuntimeException("les mots de passe ne sont pas pareils");

		AppUser oldUser = accountService.findUserByUsername(user.getUsername());

		if (oldUser != null)
			throw new RuntimeException("l\'utilisateur deja existe");

		AppUser appuser = new AppUser();
		BeanUtils.copyProperties(user, appuser);
		accountService.saveUser(appuser);
		accountService.addRoleToUser(appuser.getUsername(), "ROLE_USER");

		/* alert */
		AlertCreateAccount = true;

		/* authentify user and update security context */

		Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

		SecurityContextHolder.getContext().setAuthentication(auth);

		/* redirect to profile edit */

		RedirectView redirect = new RedirectView();
		redirect.setUrl("/user/profile");
		return new ModelAndView(redirect);

	}

	@GetMapping("/login")
	public ModelAndView getLogin() {
		model.clear();
		model.put("user", new LoginRequest());
		model.put("guest", new RegisterRequest());

		return new ModelAndView("PAGES/login", model);

	}

	@GetMapping("/user/profile")
	public ModelAndView getUserProfile() {

		model.clear();
		model.put("authenticatedUser", getAuthenticatedUser());

		/* alert for creating profile */

		if (AlertCreateAccount) {
			model.put("AlertCreateAccount", true);
			AlertCreateAccount = false;
		}

		/* alert for updating profile */

		if (AlertUpdateProfile) {

			model.put("updateProfileAlert", true);
			AlertUpdateProfile = false;
		}
		String profileImg = profilePictures.loadPictureUser(getAuthenticatedUser().getId());
		model.put("profileImg", profileImg);

		/* Portfolio */

		Portfolio portfolio = portfolioService.getPortfolio(getAuthenticatedUser().getId());

		if (portfolio == null)

		{
			int a = 0;
			model.put("numberOfProjects", a);
			model.put("numberOfTrainings", a);
			model.put("numberOfCertificats", a);

		}

		else

		{
			/* number of Projects */

			List<Projet> projects = projetService.getAllProjetUser(portfolio.getId_portfolio());
			model.put("numberOfProjects", projects.size());

			/* number of Trainings */

			List<Formation> formations = formationService.getAllFormationPortfolio(portfolio.getId_portfolio());
			model.put("numberOfTrainings", formations.size());

			/* number of Certificats */

			List<Certificat> certificats = certificatService.getAllCertificatsPortfolio(portfolio.getId_portfolio());
			model.put("numberOfCertificats", certificats.size());

		}
		return new ModelAndView("PAGES/profile", model);
	}

	/* update user info */

	@PostMapping("/user/update")
	public ModelAndView updateUserProfile(AppUser user) {
		/* authenticated user */

		AppUser authenticatedUser = this.getAuthenticatedUser();

		/* updating info */

		authenticatedUser.setAddress(user.getAddress());
		authenticatedUser.setCity(user.getCity());
		authenticatedUser.setCountry(user.getCountry());
		authenticatedUser.setEmail(user.getEmail());
		authenticatedUser.setFirstName(user.getFirstName());
		authenticatedUser.setLastName(user.getLastName());
		authenticatedUser.setJob(user.getJob());
		authenticatedUser.setPostalCode(user.getPostalCode());
		authenticatedUser.setUsername(user.getUsername());
		authenticatedUser.setPassword(user.getPassword());

		/* save user */

		accountService.saveUser(authenticatedUser);

		/* update security context */

		Authentication auth = new UsernamePasswordAuthenticationToken(authenticatedUser.getUsername(),
				user.getPassword());

		SecurityContextHolder.getContext().setAuthentication(auth);

		/* alert for update profile */

		AlertUpdateProfile = true;

		/* redirect */

		RedirectView redirect = new RedirectView();
		redirect.setUrl("/user/profile");
		return new ModelAndView(redirect);
	}

	/* get the current authenticated user */

	private AppUser getAuthenticatedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return accountService.findUserByUsername(currentPrincipalName);
	}

	/* save the profile picture of the current user */

	@PostMapping("/savePitureUser")

	public ModelAndView savePictureUser(@RequestParam("imageProfile") MultipartFile file) throws IOException {
		AppUser authenticatedUser = this.getAuthenticatedUser();
		accountService.saveImageUser(authenticatedUser.getUsername(), file);

		AlertUpdateProfile = true;

		/* redirect */

		RedirectView redirect = new RedirectView();
		redirect.setUrl("/user/profile");
		return new ModelAndView(redirect);

	}

}
