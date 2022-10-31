package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.entity.Compra;
import com.proyecto.repositories.CompraRepository;

public class CompraService {
	@Autowired
	private CompraRepository repo;
	
	public List<Compra> listarCompras(){
		return repo.findAll();
	}
	
	public Compra buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public void actualizar (Compra  bean) {
		repo.save(bean);
	}

}
