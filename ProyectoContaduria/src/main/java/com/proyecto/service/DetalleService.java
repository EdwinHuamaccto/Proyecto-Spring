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
	
	public void registrar(Detalle bean) {
		repo.save(bean);
	}
	
	public void eliminar(int cod) {
		repo.deleteById(cod);
	}
	
	public List<Detalle> listar(){
		return repo.findAll();
	}
	
	public Detalle buscar(int cod) {
		return repo.findById(cod).orElse(null);
	}
}
