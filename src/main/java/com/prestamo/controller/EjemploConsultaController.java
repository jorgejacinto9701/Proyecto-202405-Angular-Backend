package com.prestamo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.Ejemplo;
import com.prestamo.service.EjemploService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/consultaEjemplo")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class EjemploConsultaController {

	@Autowired
	private EjemploService ejemploService;
	
	@GetMapping("/consultaComplejoEjemplo")
	public List<Ejemplo> listaConsulta(
			@RequestParam String descripcion, 
			@RequestParam int idPais, 
			@RequestParam int estado, 
			@RequestParam BigDecimal longitud, 
			@RequestParam int idDias){
		List<Ejemplo> lstSalida  =ejemploService.listaConsultaCompleja("%"+descripcion+"%", idPais, estado, longitud, idDias);
		return lstSalida;
	}
	
}
