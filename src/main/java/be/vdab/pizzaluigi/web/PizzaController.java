package be.vdab.pizzaluigi.web;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.pizzaluigi.valueObjets.Pizza;

@Controller
@RequestMapping("pizzas")
public class PizzaController {

	private final static String PIZZAS_VIEW = "pizzas";
	private final Map<Long, Pizza> pizzas = new LinkedHashMap<>();

	PizzaController() {

		pizzas.put(1L, new Pizza(1, "Prosciutto", BigDecimal.valueOf(4), true));
		pizzas.put(2L, new Pizza(2, "Margherita", BigDecimal.valueOf(5), false));
		pizzas.put(3L, new Pizza(3, "Calzone", BigDecimal.valueOf(4), false));
		pizzas.put(4L, new Pizza(4, "Fungi & Olive", BigDecimal.valueOf(5), false));
		pizzas.put(23L, new Pizza(23, "Fungi & Olive", BigDecimal.valueOf(5), false));
	}

	@GetMapping
	ModelAndView pizzas() {
		return new ModelAndView(PIZZAS_VIEW, "pizzas", pizzas);
	}

	private final static String PIZZA_VIEW = "pizza";

	@GetMapping("{id}")
	ModelAndView pizza(@PathVariable long id) {
		ModelAndView modelandview = new ModelAndView(PIZZA_VIEW);
		if (pizzas.containsKey(id)) {
			modelandview.addObject(pizzas.get(id));
		}
		return modelandview;
	}

	private final static String PRIJZEN_VIEW = "prijzen";

	@GetMapping("prijzen")
	ModelAndView prijzen() {
		return new ModelAndView(PRIJZEN_VIEW, "prijzen",
				pizzas.values().stream().map(pizza -> pizza.getPrijs()).distinct().collect(Collectors.toSet()));
	}

	@GetMapping(params = "prijs")
	ModelAndView pizzasVanPrijs(BigDecimal prijs) {
		return new ModelAndView(PRIJZEN_VIEW, "pizzas",
				pizzas.values().stream().filter(pizza -> pizza.getPrijs().equals(prijs)).collect(Collectors.toList()))
						.addObject("prijs", prijs).addObject("prijzen", pizzas.values().stream()
								.map(pizza -> pizza.getPrijs()).distinct().collect(Collectors.toSet()));
	}

}
