package com.epicode.U5D4.services;

import com.epicode.U5D4.entities.Drink;
import com.epicode.U5D4.entities.Item;
import com.epicode.U5D4.entities.Pizza;
import com.epicode.U5D4.entities.Topping;
import com.epicode.U5D4.exceptions.NotFoundException;
import com.epicode.U5D4.repositories.ItemsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {
	@Autowired
	ItemsDAO itemsDAO;

	public List<Item> getAll() {
		return itemsDAO.findAll();
	}

	public List<Pizza> getPizzas() {
		return itemsDAO.findPizzas();
	}

	public List<Drink> getDrinks() {
		return itemsDAO.findDrinks();
	}

	public List<Topping> getToppings() {
		return itemsDAO.findToppings();
	}

	public Item findById(long id) {
		return itemsDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public void save(Item item) {
		itemsDAO.save(item);
	}

	public void findByIdAndDelete(long id) {
		Item order = this.findById(id);
		itemsDAO.delete(order);
	}
}
