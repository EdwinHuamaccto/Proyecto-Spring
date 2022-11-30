package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Empresa;
import com.proyecto.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	@Autowired
	private EmpresaRepository repo;
	
	public void registrar(Empresa bean) {
		repo.save(bean);
	}
	
	public void eliminar(int cod) {
		repo.deleteById(cod);
	}
	
	public List<Empresa> listar(){
		return repo.findAll();
	}
	
	public Empresa buscar(int cod) {
		return repo.findById(cod).orElse(null);
	}
	
}
