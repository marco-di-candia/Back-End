package com.epicode.U5D4;

import com.epicode.U5D4.entities.Pizza;
import com.epicode.U5D4.entities.Topping;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class U5D4ApplicationTests {

	private static AnnotationConfigApplicationContext c;

	@BeforeAll
	public static void before() {
		c = new AnnotationConfigApplicationContext(U5D4Application.class);
	}

	@ParameterizedTest
	@CsvSource({"toppings_tomato, 0", "toppings_ham, 35", "toppings_pineapple, 24"})
	void testToppingsCalories(String nomeTopping, int caloriePreviste) {
		Topping topping = c.getBean(nomeTopping, Topping.class);
		assertEquals(caloriePreviste, topping.getCalories());
	}

	@ParameterizedTest
	@CsvSource({"pizza_margherita, 792", "hawaiian_pizza, 851", "salami_pizza, 878"})
	void testPizzasCalories(String nomePizza, int caloriePreviste) {
		Pizza pizza = c.getBean(nomePizza, Pizza.class);
		assertEquals(caloriePreviste, pizza.getCalories());
	}
}
