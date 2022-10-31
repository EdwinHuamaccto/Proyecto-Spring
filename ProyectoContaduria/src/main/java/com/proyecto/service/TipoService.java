package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Tipo;
import com.proyecto.repositories.TipoRepository;

@Service
public class TipoService {
	@Autowired
	private TipoRepository repo;
	
	public List<Tipo> listar(){
		return repo.findAll();
	}

}
