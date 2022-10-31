package com.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.Detalle;

public interface DetalleRepository extends JpaRepository<Detalle, Integer> {
	
}
