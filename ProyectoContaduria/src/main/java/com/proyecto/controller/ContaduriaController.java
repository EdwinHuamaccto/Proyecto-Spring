package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.entity.Detalle;
import com.proyecto.service.DetalleService;
import com.proyecto.service.TipoService;

@Controller
@RequestMapping("/LibroDiario")
public class ContaduriaController {
	@Autowired
	private TipoService serviceTipo;
	@Autowired
	private DetalleService serviceDetalle;
	
	@RequestMapping("/lista")
	public String inicio(Model model) {
		model.addAttribute("tipos",serviceTipo.listar());
		return "LibroDiario";
	}
	
	@RequestMapping("/registroDetalle")
	public String registrarDetalle(@RequestParam("detalle") String detalle,
								   @RequestParam("monto") double monto) {
		Detalle obj=new Detalle();
		obj.setCoddetalle(null);
		obj.setDetalle(detalle);
		obj.setMonto(monto);
		serviceDetalle.registrar(obj);
		return "redirect:/LibroDiario/lista";
	}
}
