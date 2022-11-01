package com.proyecto.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.LibroDiario;

public interface LibroRepository extends JpaRepository<LibroDiario, Integer> {
	@Query("select l from LibroDiario l where l.fecha=?1")
	public List<LibroDiario> listarLibro(Date date);
}
