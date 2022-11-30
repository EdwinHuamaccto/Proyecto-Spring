package com.proyecto.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Enlace;
import com.proyecto.entity.Usuario;
import com.proyecto.service.UsuarioService;

@SessionAttributes({"ENLACES","USUARIO"})
@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService servicio;
	
	@GetMapping("/login")
	public String login(@RequestParam(value = "error",required = false) String error,
						@RequestParam(value = "logout",required = false) String logout,	
						Model model, Principal principal, RedirectAttributes redirect) {
		if (error!=null) {
			model.addAttribute("error", "Usuario o contraseña incorrectos");
		}
		if (principal!=null) {
			redirect.addFlashAttribute("warning", "ATENCIÓN: Ya ha iniciado sesión previamente");
			return "redirect:/menu";
		}
		if (logout!=null) {
			model.addAttribute("success", "Sesión finalizada");
		}
		return "login";
	}
	
	@RequestMapping("/menu")
	public String menu(Authentication aut,Model model) {
		String vLoguin=aut.getName();
		Usuario u=servicio.loginUsuario(vLoguin);
		List<Enlace> lista=servicio.enlacesDelUsuario(u.getRol().getCodigo());
		model.addAttribute("ENLACES", lista);
		model.addAttribute("USUARIO", u.getNombre()+" "+u.getApellido());
		return "menu";
	}
}
