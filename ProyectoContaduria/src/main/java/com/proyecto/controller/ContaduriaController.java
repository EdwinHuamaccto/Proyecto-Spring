package com.proyecto.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.entity.Detalle;
import com.proyecto.entity.Empresa;
import com.proyecto.entity.LibroDiario;
import com.proyecto.entity.Tipo;
import com.proyecto.service.DetalleService;
import com.proyecto.service.LibroService;
import com.proyecto.service.TipoService;

@Controller
@RequestMapping("/LibroDiario")
public class ContaduriaController {

@Autowired
private TipoService serviceTipo;
@Autowired
private DetalleService serviceDetalle;
@Autowired
private LibroService serviceLibro;

@RequestMapping("/lista")
	public String inicio(Model model) {
		model.addAttribute("tipos",serviceTipo.listar());
	    model.addAttribute("detalles", serviceDetalle.listar());
		return "LibroDiario.html";
	}
	@RequestMapping("/registroDetalle")
	public String registrarDetalle(@RequestParam("fecha") String fecha,
								   @RequestParam("detalle") int detalle,
								   @RequestParam("importe") String importe,
								   @RequestParam("monto") double monto,
								   @RequestParam("tipo") int tipo) {
		try {
			LibroDiario lib=new LibroDiario();
			lib.setCodigo(0);
			lib.setFecha(new SimpleDateFormat("yyyy-mm-dd").parse(fecha));
			lib.setImporte(importe);
			lib.setMonto(monto);
			
			
			Tipo tip=new Tipo();
			tip.setCodtipo(tipo);
			lib.setTipo(tip);
			
			Detalle det=new Detalle();
			det.setCoddetalle(detalle);
			lib.setDetalle(det);
			
			Empresa emp=new Empresa();
			emp.setCodempresa(1);
			lib.setEmpresa(emp);
			
			serviceLibro.registrar(lib);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return "redirect:/LibroDiario/lista";
	}
}
