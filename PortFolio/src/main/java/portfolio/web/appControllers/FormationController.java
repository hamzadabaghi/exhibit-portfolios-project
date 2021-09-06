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
import portfolio.entities.Formation;

import portfolio.services.FormationService;

@Controller
@RequestMapping("/formations")
public class FormationController {

	@Autowired
	private FormationService formationService;
	@Autowired
	Map<String, Object> model;

	/* to dispatch to create a new formation */

	@GetMapping("/addFormation")
	public ModelAndView addNewFormation() {

		String viewName = "formation-form";
		model.clear();
		model.put("formation", new Formation());
		return new ModelAndView(viewName, model);

	}

	/* create formations */

	@PostMapping("/create")
	public ModelAndView createFormation(Formation formation) {
		model.clear();
		formationService.createFormation(formation);
		RedirectView redirect = new RedirectView();
		redirect.setUrl("/formation/all");
		return new ModelAndView(redirect);
	}

	/* delete formation */

	@GetMapping("/delete{id}")
	public ModelAndView deleteFormation(@PathVariable("id") String id_formation) {
		formationService.deleteFormation(Long.parseLong(id_formation));
		RedirectView redirect = new RedirectView();
		redirect.setUrl("/portfolio/showport");
		return new ModelAndView(redirect);

	}

	@PostMapping("/update")
	public ModelAndView deleteFormation(@RequestParam Map<String, String> queryParams) throws ParseException {
		Formation formation = new Formation();
		Long id_formation = Long.parseLong(queryParams.get("idform"));
		Long id_portfolio = Long.parseLong(queryParams.get("idportfolio"));
		formation.setTitre_formation(queryParams.get("titre_form"));
		formation.setLieu_formation(queryParams.get("lieu"));
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = parser.parse(queryParams.get("date_debut_form"));
		formation.setDate_debut_formation(date1);
		Date date2 = parser.parse(queryParams.get("date_fin_form"));
		formation.setDate_fin_formation(date2);
		formation.setDescription_formation(queryParams.get("description_formation"));
		formation.setId_portfolio(id_portfolio);
		formation.setId_formation(id_formation);
		formationService.createFormation(formation);
		RedirectView redirect = new RedirectView();
		redirect.setUrl("/portfolio/showport");
		return new ModelAndView(redirect);

	}
}
