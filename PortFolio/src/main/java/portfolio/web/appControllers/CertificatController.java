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
import portfolio.entities.Certificat;
import portfolio.services.CertificatService;

@Controller
@RequestMapping("/certificats")
public class CertificatController {

	@Autowired
	private CertificatService certificatService;

	@Autowired
	Map<String, Object> model;

	@GetMapping("/delete{id}")
	public ModelAndView deleteFormation(@PathVariable("id") String id_certificat) {
		certificatService.deleteCertificat(Long.parseLong(id_certificat));
		RedirectView redirect = new RedirectView();
		redirect.setUrl("/portfolio/showport");
		return new ModelAndView(redirect);

	}

	@PostMapping("/update")
	public ModelAndView deleteFormation(@RequestParam Map<String, String> queryParams) throws ParseException {
		Certificat certificat = new Certificat();
		Long id_certificat = Long.parseLong(queryParams.get("idcert"));
		Long id_portfolio = Long.parseLong(queryParams.get("idportfolio"));
		certificat.setTitre_certificat(queryParams.get("titre"));
		certificat.setOrganisation_certificat(queryParams.get("organisationt"));
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = parser.parse(queryParams.get("date_debut_cert"));
		certificat.setDate_debut_certificat(date1);
		Date date2 = parser.parse(queryParams.get("date_fin_cert"));
		certificat.setDate_expiration_certificat(date2);
		certificat.setDescription_certificat(queryParams.get("description_certificat"));
		certificat.setId_portfolio(id_portfolio);
		certificat.setId_certificat(id_certificat);

		certificatService.createCertificat(certificat);
		RedirectView redirect = new RedirectView();
		redirect.setUrl("/portfolio/showport");
		return new ModelAndView(redirect);

	}

}