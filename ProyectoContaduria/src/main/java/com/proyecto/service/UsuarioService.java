package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Enlace;
import com.proyecto.entity.Usuario;
import com.proyecto.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario loginUsuario(String vLoguin) {
		return repo.iniciarSesion(vLoguin);
	}
	
	public List<Enlace> enlacesDelUsuario(int rol){
		return repo.traerEnlacesDelUsuario(rol);
	}
}
