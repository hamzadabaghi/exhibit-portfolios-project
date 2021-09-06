package portfolio.web.appControllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import portfolio.entities.Projet;
import portfolio.services.ProjetService;

@Controller
@RequestMapping("/projets")
public class ProjetController {

	@Autowired
	private ProjetService projetService;

	@Autowired
	Map<String, Object> model;

	@GetMapping("/delete{id}")
	public ModelAndView deleteProjet(@PathVariable("id") String id_projet) {
		projetService.deleteProjet(Long.parseLong(id_projet));
		RedirectView redirect = new RedirectView();
		redirect.setUrl("/portfolio/showport");
		return new ModelAndView(redirect);

	}

	@PostMapping("/update")
	public ModelAndView deleteFormation(@RequestParam Map<String, String> queryParams) throws ParseException {
		Projet projet = new Projet();
		Long id_projet = Long.parseLong(queryParams.get("id"));
		Long id_portfolio = Long.parseLong(queryParams.get("idportfolio"));
		projet.setTitre_projet(queryParams.get("titre"));
		projet.setLiens_projet(queryParams.get("liens_projet"));
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = parser.parse(queryParams.get("date_debut"));
		projet.setDate_debut(date1);
		Date date2 = parser.parse(queryParams.get("date_fin"));
		projet.setDate_fin(date2);
		projet.setDescription_projet(queryParams.get("description_projet"));
		projet.setId_portfolio(id_portfolio);
		projet.setId_projet(id_projet);

		projetService.createProjet(projet);
		RedirectView redirect = new RedirectView();
		redirect.setUrl("/portfolio/showport");
		return new ModelAndView(redirect);

	}

}
