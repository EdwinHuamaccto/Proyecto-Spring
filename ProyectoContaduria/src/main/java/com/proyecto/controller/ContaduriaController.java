package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.service.TipoService;

@Controller
@RequestMapping("/LibroDiario")
public class ContaduriaController {
@Autowired
private TipoService serviceTipo;
@RequestMapping("/lista")
public String inicio(Model model) {
	model.addAttribute("tipos",serviceTipo.listar());

	return "LibroDiario";
}
	
}
