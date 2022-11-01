package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Compra;
import com.proyecto.service.CompraService;
import com.proyecto.service.TipoAfectoService;

@Controller
@RequestMapping("/MovimientoTributario")
public class CompraController {
	
@Autowired
private TipoAfectoService servicioAfe;
@Autowired
private CompraService servicioCom;
	
@RequestMapping("/listaCompra")
public String lista(Model model) {
	
	model.addAttribute("compra", servicioCom.listarCompras());
	model.addAttribute("tipoAfecto", servicioAfe.listarAfectos());
	
	return "compra";
}

@RequestMapping("/buscar")
@ResponseBody
public Compra buscar(@RequestParam("codigo") Integer cod) {
	return servicioCom.buscarPorID(cod);
}

@RequestMapping("/actualizarCompra")
public String actualizar(@RequestParam("codigocom") Integer cod, @RequestParam("afecto") double afe,
		@RequestParam("inaf") double ina, @RequestParam("total_vc") double total, @RequestParam("igv") double igv,
		@RequestParam("precio_compra") double pre,
		RedirectAttributes redirect)  {
	try {
		Compra com=new Compra();
		com.setCodigocom(cod);
		com.setAfecto(afe);
		com.setInaf(ina);
		com.setTotal_vc(total);
		com.setIgv(igv);
		
		
		redirect.addFlashAttribute("MENSAJE","Compra Actualizada");
		
	} catch (Exception e) {
		redirect.addFlashAttribute("MENSAJE","Error en la Actualizacion");
		e.printStackTrace();
	}
	
	return "redirect:/MovimientoTributario/listaCompra";	
}



}
