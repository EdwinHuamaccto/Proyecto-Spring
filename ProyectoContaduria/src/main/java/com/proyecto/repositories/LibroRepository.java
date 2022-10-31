package com.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.LibroDiario;

public interface LibroRepository extends JpaRepository<LibroDiario, Integer> {

}
