package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.ImporteParcial;
import com.proyecto.repositories.ImporteRepository;

@Service
public class ImporteService {
	@Autowired
	private ImporteRepository repo;
	
	public void registrar(ImporteParcial bean) {
		repo.save(bean);
	}
	
	public void eliminar(int cod) {
		repo.deleteById(cod);
	}
	
	public List<ImporteParcial> listar(){
		return repo.findAll();
	}
	
	public ImporteParcial buscar(int cod) {
		return repo.findById(cod).orElse(null);
	}
}
