package com.epicode.U5D4;

import com.epicode.U5D4.entities.*;
import com.epicode.U5D4.services.ItemsService;
import com.epicode.U5D4.services.MenusService;
import com.epicode.U5D4.services.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SaveRunner implements CommandLineRunner {
	@Autowired
	private MenusService menusService;
	@Autowired
	private ItemsService itemsService;
	@Autowired
	private TablesService tablesService;


	@Override
	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5D4Application.class);
		try {
			Table table1 = ctx.getBean("Tavolo1", Table.class);
			Table table2 = ctx.getBean("Tavolo2", Table.class);
			Table table3 = ctx.getBean("Tavolo3", Table.class);
			tablesService.save(table1);
			tablesService.save(table2);
			tablesService.save(table3);

			Menu menu = new Menu("Menù del giorno");
			menusService.save(menu);

			Topping tomato = ctx.getBean("toppings_tomato", Topping.class);
			tomato.setMenu(menu);
			Topping cheese = ctx.getBean("toppings_cheese", Topping.class);
			cheese.setMenu(menu);
			Topping ham = ctx.getBean("toppings_ham", Topping.class);
			ham.setMenu(menu);
			Topping pineapple = ctx.getBean("toppings_pineapple", Topping.class);
			pineapple.setMenu(menu);
			Topping salami = ctx.getBean("toppings_salami", Topping.class);
			salami.setMenu(menu);
			Pizza margherita = ctx.getBean("pizza_margherita", Pizza.class);
			margherita.setMenu(menu);
			Pizza hawaiian = ctx.getBean("hawaiian_pizza", Pizza.class);
			hawaiian.setMenu(menu);
			Pizza salamiPizza = ctx.getBean("salami_pizza", Pizza.class);
			salamiPizza.setMenu(menu);
			Pizza margheritaXL = ctx.getBean("salami_pizza_xl", Pizza.class);
			margheritaXL.setMenu(menu);
			Drink lemonade = ctx.getBean("lemonade", Drink.class);
			lemonade.setMenu(menu);
			Drink water = ctx.getBean("water", Drink.class);
			water.setMenu(menu);
			Drink wine = ctx.getBean("wine", Drink.class);
			wine.setMenu(menu);
			itemsService.save(tomato);
			itemsService.save(cheese);
			itemsService.save(ham);
			itemsService.save(pineapple);
			itemsService.save(salami);
			itemsService.save(margherita);
			itemsService.save(hawaiian);
			itemsService.save(salamiPizza);
			itemsService.save(margheritaXL);
			itemsService.save(lemonade);
			itemsService.save(water);
			itemsService.save(wine);

			Menu found = menusService.findById(1);
			found.printMenu();

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			ctx.close();
		}
	}
}
