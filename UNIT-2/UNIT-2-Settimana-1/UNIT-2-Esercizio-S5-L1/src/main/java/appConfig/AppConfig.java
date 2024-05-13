package appConfig;

import bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


import java.util.List;


@Configuration
public class AppConfig {
	@Bean
	@Primary
	public Pizza margherita(){
		Pizza pizza = new Pizza();
		pizza.setNome("Margherita");
		pizza.setIncredienti(List.of(pomodoro(),mozzarella()));
		pizza.setCalorie(200);
		pizza.setPrezzo(6);
		return  pizza;
	}
	@Bean

	public Pizza diavola(){
		Pizza pizza = new Pizza();
		pizza.setNome("diavola");
		pizza.setIncredienti(List.of(pomodoro(),mozzarella(),salame()));
		pizza.setCalorie(200);
		pizza.setPrezzo(6);
		return  pizza;
	}
	@Bean
	public Incredienti salame(){
		Incredienti incredienti = new Incredienti();
		incredienti.setIncredinte("salame piccante");
		incredienti.setCalorie(100);
		incredienti.setPrezzo(13);
		return incredienti;
	}
	@Bean
	public Incredienti pomodoro(){
		Incredienti incredienti = new Incredienti();
		incredienti.setIncredinte("pomodoro");
		incredienti.setCalorie(50);
		incredienti.setPrezzo(10);
		return incredienti;
	}
	@Bean
	public Incredienti mozzarella(){
		Incredienti incredienti = new Incredienti();
		incredienti.setIncredinte("mozzarella");
		incredienti.setCalorie(30);
		incredienti.setPrezzo(5);
		return incredienti;
	}
	@Bean
	public Menu menu(){
		Menu menu = new Menu();
		menu.setPizza(List.of(margherita(), diavola()));
		menu.setBevante(List.of(pepsi(), cocacola()));
		menu.setIncredienti(List.of(mozzarella(), patatine(), pomodoro()));
		return menu;
	}


	@Bean
	public Bevande pepsi(){
		Bevande bevanda = new Bevande();
		bevanda.setBevanda("pepsi");
		return bevanda;
	}
	@Bean
	public Bevande cocacola(){
		Bevande bevanda = new Bevande();
		bevanda.setBevanda("cocacola");
		bevanda.setCalorie(5);
		bevanda.setPrezzo(2);
		return bevanda;
	}
	@Bean
	public Incredienti patatine() {
		Incredienti incrediente = new Incredienti();
		incrediente.setIncredinte("patatine");
		incrediente.setCalorie(20);
		incrediente.setPrezzo(4);
		return incrediente;
	}




}
