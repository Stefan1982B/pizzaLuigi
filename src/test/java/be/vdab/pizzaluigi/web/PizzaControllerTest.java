package be.vdab.pizzaluigi.web;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;
import static org.mockito.Mockito.verify; 
import static org.mockito.Mockito.when;

import be.vdab.pizzaluigi.services.EuroService;
import be.vdab.pizzaluigi.services.PizzaService;
import be.vdab.pizzaluigi.valueObjets.Pizza;

@RunWith(MockitoJUnitRunner.class)
public class PizzaControllerTest {

	private PizzaController controller;
	@Mock
	private EuroService dummyEuroService;
	private PizzaService dummyPizzaService;

	@Before
	public void before() {
		when(dummyPizzaService.read(1)).thenReturn(
				Optional.of(new Pizza(1, "Test", BigDecimal.ONE, true)));
		controller = new PizzaController(dummyEuroService, dummyPizzaService);
	}

	@Test
	public void pizzasWerktSamenMetPizzasDotJsp() {
		ModelAndView modelAndView = controller.pizzas();
		assertEquals("pizzas", modelAndView.getViewName());
	}

	@Test
	public void pizzasGeeftPizzasDoor() {
		ModelAndView modelAndView = controller.pizzas();
		assertTrue(modelAndView.getModel().containsKey("pizzas"));
	}

	@Test
	public void pizzaWerktSamenMetPizzaDotJsp() {
		ModelAndView modelAndView = controller.pizza(1);
		assertEquals("pizza", modelAndView.getViewName());
	}

	@Test
	public void pizzaGeeftPizzaDoor() {
		ModelAndView modelAndView = controller.pizza(1);
		assertTrue(modelAndView.getModel().containsKey("pizza"));
	}
	// @Test
	// public void onbestaandePizza() {
	// ModelAndView modelAndView = controller.pizza(-1);
	// assertFalse(modelAndView.getModel().containsKey("pizza"));
	// }

}
