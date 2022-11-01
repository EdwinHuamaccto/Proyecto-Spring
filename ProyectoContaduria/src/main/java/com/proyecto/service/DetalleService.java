package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Detalle;
import com.proyecto.repositories.DetalleRepository;

@Service
public class DetalleService {
	@Autowired
	private DetalleRepository repo;
	
	public List<Detalle> listar(){
		return repo.findAll();
	}
}
