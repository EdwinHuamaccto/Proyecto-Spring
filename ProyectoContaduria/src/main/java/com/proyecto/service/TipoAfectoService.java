package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.TipoAfecto;
import com.proyecto.repositories.TipoAfectoRepository;
@Service
public class TipoAfectoService {
	@Autowired
	private TipoAfectoRepository repo;
	
	public List<TipoAfecto> listarAfectos(){
		return repo.findAll();
	}

}
