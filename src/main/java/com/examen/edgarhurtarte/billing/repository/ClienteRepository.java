package com.examen.edgarhurtarte.billing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.edgarhurtarte.billing.model.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
	


}
