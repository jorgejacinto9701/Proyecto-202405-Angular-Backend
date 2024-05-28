package com.centroinformacion.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Ejemplo;
import com.centroinformacion.entity.Usuario;
import com.centroinformacion.service.EjemploService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/ejemplo")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class EjemploRegistraController {

	@Autowired
	private EjemploService ejemploService;
	
	@GetMapping
	public ResponseEntity<List<Ejemplo>> lista(){
		List<Ejemplo> lstSalida = ejemploService.listaEjemplo();
		return ResponseEntity.ok(lstSalida);
	}

	@PostMapping
	public ResponseEntity<?> registra(@RequestBody Ejemplo objEjemplo){
		HashMap<String, Object> salida = new HashMap<>();
		objEjemplo.setFechaRegistro(new Date());
		objEjemplo.setFechaActualizacion(new Date());
		objEjemplo.setEstado(AppSettings.ACTIVO);
		
		Usuario objUsuario = new Usuario();
		objUsuario.setIdUsuario(1);
		
		objEjemplo.setUsuarioRegistro(objUsuario);
		objEjemplo.setUsuarioActualiza(objUsuario);
		
		Ejemplo objSalida = ejemploService.insertaActualizaEjemplo(objEjemplo);
		if (objSalida == null) {
			salida.put("mensaje", "Error en el registro");
		}else {
			salida.put("mensaje", "Registro de ejemplo con el ID >>> " + objEjemplo.getIdEjemplo() + 
										" >>> DES >> "+ objEjemplo.getDescripcion());
		}
		return ResponseEntity.ok(salida);
	}
}










