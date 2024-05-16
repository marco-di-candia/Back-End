package com.epicode.U5D4.services;

import com.epicode.U5D4.entities.Menu;
import com.epicode.U5D4.exceptions.NotFoundException;
import com.epicode.U5D4.repositories.MenusDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenusService {
	@Autowired
	MenusDAO menusDAO;

	public List<Menu> getAll() {
		return menusDAO.findAll();
	}

	public Menu findById(long id) {
		return menusDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public void save(Menu menu) {
		menusDAO.save(menu);
	}

	public void findByIdAndDelete(long id) {
		Menu order = this.findById(id);
		menusDAO.delete(order);
	}
}
