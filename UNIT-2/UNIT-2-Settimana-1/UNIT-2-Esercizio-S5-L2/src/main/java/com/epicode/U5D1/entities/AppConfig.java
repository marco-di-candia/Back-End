package com.epicode.U5D1.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
	@Bean(name = "toppings_tomato")
	public Topping toppingTomatoBean() {
		return new Topping("Tomato", 0, 0);
	}

	@Bean(name = "toppings_cheese")
	public Topping toppingCheeseBean() {
		return new Topping("Cheese", 92, 0.69);
	}

	@Bean(name = "toppings_ham")
	public Topping toppingHamBean() {
		return new Topping("Ham", 35, 0.99);
	}

	@Bean(name = "toppings_pineapple")
	public Topping toppingPineappleBean() {
		return new Topping("Pineapple", 24, 0.79);
	}

	@Bean(name = "toppings_salami")
	public Topping toppingSalamiBean() {
		return new Topping("Salami", 86, 0.99);
	}

	@Bean(name = "ordine")
	public Order order1() {
		Order order = new Order();
		order.setOraAquisizione(LocalTime.of(0,30));
		order.setNumeroOrdine(01);
		order.setStatoOrdine(StatoOrdine.INCORSO);
		order.setNumeroCoperti(4);
		order.setMenuItem(List.of(pizzaHawaiianBean(),pizzaSalamiXlBean()));
		double totale = order.getSomma();
		order.setPrezzoTotale(totale);
		return  order;
	}
	@Bean(name = "table1")
	public Table table() {
		Table table = new Table();
		table.setTableNumber(1);
		table.setCopertiMax(5);
		table.setLibero(true);
		return table;
	}





	@Bean(name = "pizza_margherita")
	public Pizza pizzaMargheritaBean() {
		List<Topping> tList = new ArrayList<>();
		tList.add(toppingTomatoBean());
		tList.add(toppingCheeseBean());
		return new Pizza("Pizza Margherita", tList, false);
	}

	@Bean(name = "hawaiian_pizza")
	public Pizza pizzaHawaiianBean() {
		List<Topping> tList = new ArrayList<>();
		tList.add(toppingTomatoBean());
		tList.add(toppingCheeseBean());
		tList.add(toppingHamBean());
		tList.add(toppingPineappleBean());
		return new Pizza("Hawaiian Pizza", tList, false);
	}

	@Bean(name = "salami_pizza")
	public Pizza pizzaSalamiBean() {
		List<Topping> tList = new ArrayList<>();
		tList.add(toppingTomatoBean());
		tList.add(toppingCheeseBean());
		tList.add(toppingSalamiBean());
		return new Pizza("Salami Pizza", tList, false);
	}

	@Bean(name = "salami_pizza_xl")
	public Pizza pizzaSalamiXlBean() {
		List<Topping> tList = new ArrayList<>();
		tList.add(toppingTomatoBean());
		tList.add(toppingCheeseBean());
		tList.add(toppingSalamiBean());
		return new Pizza("Salami Pizza XL", tList, true);
	}

	@Bean(name = "lemonade")
	public Drink lemonadeBean() {
		return new Drink("Lemonade", 128, 1.29);
	}

	@Bean(name = "water")
	public Drink waterBean() {
		return new Drink("Water", 0, 1.29);
	}

	@Bean(name = "wine")
	public Drink wineBean() {
		return new Drink("Wine", 607, 7.49);
	}

	@Bean(name = "menu")
	public Menu menuBean() {
		List<Pizza> pizzaList = new ArrayList<>();
		List<Drink> drinkList = new ArrayList<>();
		List<Topping> toppingsList = new ArrayList<>();

		pizzaList.add(pizzaMargheritaBean());
		pizzaList.add(pizzaHawaiianBean());
		pizzaList.add(pizzaSalamiBean());
		pizzaList.add(pizzaSalamiXlBean());

		drinkList.add(lemonadeBean());
		drinkList.add(waterBean());
		drinkList.add(wineBean());

		toppingsList.add(toppingTomatoBean());
		toppingsList.add(toppingCheeseBean());
		toppingsList.add(toppingSalamiBean());
		toppingsList.add(toppingHamBean());
		toppingsList.add(toppingPineappleBean());

		return new Menu(pizzaList, drinkList, toppingsList);


	}
}
