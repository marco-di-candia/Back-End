package com.epicode.U5D4.repositories;

import com.epicode.U5D4.entities.Drink;
import com.epicode.U5D4.entities.Item;
import com.epicode.U5D4.entities.Pizza;
import com.epicode.U5D4.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsDAO extends JpaRepository<Item, Long> {
	@Query("SELECT p FROM Pizza p")
	List<Pizza> findPizzas();

	@Query("SELECT d FROM Drink d")
	List<Drink> findDrinks();

	@Query("SELECT t FROM Topping t")
	List<Topping> findToppings();
}
