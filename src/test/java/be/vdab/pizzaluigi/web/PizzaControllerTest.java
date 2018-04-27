package be.vdab.pizzaluigi.web;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class PizzaControllerTest {
	
	private pizzaController controller;
	 @Before
	 public void before() {
	 controller = new pizzaController();
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
