package com.epicode.U5D4.services;

import com.epicode.U5D4.entities.Order;
import com.epicode.U5D4.exceptions.NotFoundException;
import com.epicode.U5D4.repositories.OrdersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
	@Autowired
	OrdersDAO ordersDAO;

	public List<Order> getAll() {
		return ordersDAO.findAll();
	}

	public Order findById(long id) {
		return ordersDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public void save(Order order) {
		ordersDAO.save(order);
	}

	public void findByIdAndDelete(long id) {
		Order order = this.findById(id);
		ordersDAO.delete(order);
	}
}
