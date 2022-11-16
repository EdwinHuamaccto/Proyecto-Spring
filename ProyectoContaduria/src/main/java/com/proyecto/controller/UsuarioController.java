package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.proyecto.entity.Enlace;
import com.proyecto.entity.Usuario;
import com.proyecto.service.UsuarioService;

@SessionAttributes({"ENLACES","USUARIO"})
@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService servicio;
	
	@RequestMapping("/login")
	public String login() {
		return "inicio";
	}
	
	@RequestMapping("/menu")
	public String menu(Authentication aut,Model model) {
		String vLoguin=aut.getName();
		Usuario u=servicio.loginUsuario(vLoguin);
		List<Enlace> lista=servicio.enlacesDelUsuario(u.getRol().getCodigo());
		model.addAttribute("ENLACES", lista);
		model.addAttribute("USUARIO", u.getNombre()+" "+u.getApellido());
		return "Menu";
	}
}
