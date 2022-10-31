package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.LibroDiario;
import com.proyecto.repositories.LibroRepository;

@Service
public class LibroService {
	@Autowired
	private LibroRepository repo;
	
	public void registrar(LibroDiario bean) {
		repo.save(bean);
	}
	
	public void eliminar(int cod) {
		repo.deleteById(cod);
	}
	
	public List<LibroDiario> listar(){
		return repo.findAll();
	}
	
	public LibroDiario buscar(int cod) {
		return repo.findById(cod).orElse(null);
	}
}
