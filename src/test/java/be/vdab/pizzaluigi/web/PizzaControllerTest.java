package be.vdab.pizzaluigi.web;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.pizzaluigi.services.EuroService;

@RunWith(MockitoJUnitRunner.class) 
public class PizzaControllerTest {
	
	private PizzaController controller;
	@Mock private EuroService dummyEuroService;
	 @Before
	 public void before() {
	 controller = new PizzaController(dummyEuroService);
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
		 @Test
		 public void onbestaandePizza() {
		 ModelAndView modelAndView = controller.pizza(-1);
		 assertFalse(modelAndView.getModel().containsKey("pizza"));
		 }

}
