package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Detalle;
import com.proyecto.entity.Empresa;
import com.proyecto.service.DetalleService;
import com.proyecto.service.EmpresaService;

@Controller
@RequestMapping("/mantenimiento")
public class MantenimientoController {
	@Autowired
	private EmpresaService serviceEmp;
	@Autowired
	private DetalleService serviceDet;
	
	@RequestMapping("/empresaLis")
	public String empresa(Model model) {
		model.addAttribute("empresas", serviceEmp.listar());
		return "empresa";
	}
	
	@RequestMapping("/buscarEmpresa")
	@ResponseBody
	public Empresa buscarEmpresa(@RequestParam("codigo") int cod) {
		return serviceEmp.buscar(cod);
	}

	@RequestMapping("/eliminarEmpresa")
	public void eliminarEmp(@RequestParam("codigo") int cod,
						 RedirectAttributes redirect) {
		try {
			serviceEmp.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE", "Registro eliminado");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE", "Error al eliminar");
		}
	}
	
	@RequestMapping("/empresa")
	public String registrarEmpresa(@RequestParam("codigo") int cod,
								   @RequestParam("nombre") String nom,
								   RedirectAttributes redirect) {
		try {
			Empresa emp=new Empresa();
			emp.setCodempresa(cod);
			emp.setNomempresa(nom);
			serviceEmp.registrar(emp);
			if (cod==0) {
				redirect.addFlashAttribute("MENSAJE", "Empresa REGISTRADA");
			} else {
				redirect.addFlashAttribute("MENSAJE", "Empresa ACTUALIZADA");
			}
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE", "Error en el registro");
		}
		return "redirect:/mantenimiento/empresaLis";
	}
	
	@RequestMapping("/detalleLis")
	public String detalle(Model model) {
		model.addAttribute("detalles", serviceDet.listar());
		return "detalle";
	}
	
	@RequestMapping("/buscarDetalle")
	@ResponseBody
	public Detalle buscarDetalle(@RequestParam("codigo") int cod) {
		return serviceDet.buscar(cod);
	}
	
	@RequestMapping("/eliminarDetalle")
	public void eliminarDet(@RequestParam("codigo") int cod,
						 RedirectAttributes redirect) {
		try {
			serviceDet.borrar(cod);
			redirect.addFlashAttribute("MENSAJE", "Registro eliminado");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE", "Error al eliminar");
		}
	}
	
	@RequestMapping("/detalle")
	public String registrarDetalle(@RequestParam("codigo") int cod,
								   @RequestParam("descripcion") String desc,
								   RedirectAttributes redirect) {
		try {
			Detalle det=new Detalle();
			det.setCoddetalle(cod);
			det.setDetalle(desc);
			serviceDet.registrar(det);
			if (cod==0) {
				redirect.addFlashAttribute("MENSAJE", "Detalle REGISTRADO");
			} else {
				redirect.addFlashAttribute("MENSAJE", "Detalle ACTUALIZADO");
			}
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE", "Error en el registro");
		}
		return "redirect:/mantenimiento/detalleLis";
	}
}
