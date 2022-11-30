package com.proyecto.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.entity.LibroDiario;
import com.proyecto.entity.ReportePOJO;
import com.proyecto.service.LibroService;
import com.proyecto.util.Libreria;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/reporte")
public class ReporteController {
	@Autowired
	private LibroService serviceLibro;
	
	@RequestMapping("/libro")
	public void reporte(HttpServletResponse response) {
		try {
			List<LibroDiario> lista=serviceLibro.listar();
			List<ReportePOJO> lstReport=new ArrayList<ReportePOJO>();
			for (LibroDiario lib : lista) {
				ReportePOJO obj=new ReportePOJO();
				obj.setEmpresa(lib.getEmpresa().getNomempresa());
				obj.setDetalle(lib.getDetalle().getDetalle());
				obj.setImporte(lib.getImporte());
				obj.setMonto(lib.getMonto());
				obj.setFecha(lib.getFecha());
				obj.setTipo(lib.getTipo().getDescripcion());
				lstReport.add(obj);
			}
			File file=ResourceUtils.getFile("classpath:reporte_libro.jrxml");
			JRBeanCollectionDataSource data=new JRBeanCollectionDataSource(lstReport);
			JasperPrint print=Libreria.generarReporte(file, data);
			response.setContentType("application/pdf");
			OutputStream salida=response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(print, salida);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
