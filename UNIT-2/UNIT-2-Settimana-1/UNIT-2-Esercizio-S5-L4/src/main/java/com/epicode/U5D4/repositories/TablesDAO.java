package com.epicode.U5D4.repositories;

import com.epicode.U5D4.entities.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablesDAO extends JpaRepository<Table, Long> {
}
