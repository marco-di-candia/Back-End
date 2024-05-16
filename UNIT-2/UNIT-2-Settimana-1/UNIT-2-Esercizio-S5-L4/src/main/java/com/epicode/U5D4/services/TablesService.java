package com.epicode.U5D4.services;

import com.epicode.U5D4.entities.Table;
import com.epicode.U5D4.exceptions.NotFoundException;
import com.epicode.U5D4.repositories.TablesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TablesService {
	@Autowired
	TablesDAO tablesDAO;

	public List<Table> getAll() {
		return tablesDAO.findAll();
	}

	public Table findById(long id) {
		return tablesDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public void save(Table table) {
		tablesDAO.save(table);
	}

	public void findByIdAndDelete(long id) {
		Table order = this.findById(id);
		tablesDAO.delete(order);
	}
}
