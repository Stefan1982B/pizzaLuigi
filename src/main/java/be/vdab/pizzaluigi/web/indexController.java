package be.vdab.pizzaluigi.web;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.pizzaluigi.valueObjets.Adres;
import be.vdab.pizzaluigi.valueObjets.Persoon;

@Controller
@RequestMapping("/")
class indexController {
	@GetMapping
	ModelAndView index() {
		  String boodschap;
		int uur = LocalTime.now().getHour();
		if (uur < 12) {
			boodschap = "Goede morgen";
		} else if (uur < 17) {
			boodschap = "Goede middag";
		} else {
			boodschap = "Goede avond";
		}

		ModelAndView modelandview = new ModelAndView ("index", "boodschap", boodschap);
		  modelandview.addObject("lievelingsgetal", 7);
		  modelandview.addObject("zaakvoerder", new Persoon("Luigi", "Peperone", 7, true, new Adres("Grote Markt", "3" , 8490, "oudenaarede")));
		  
		  return modelandview;

	}
}
