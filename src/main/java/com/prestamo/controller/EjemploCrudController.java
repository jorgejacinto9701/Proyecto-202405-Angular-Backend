package com.prestamo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.Ejemplo;
import com.prestamo.service.EjemploService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/crudEjemplo")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class EjemploCrudController {

	@Autowired
	private EjemploService ejemploService;
	
	
	@GetMapping("/listaEjemploPorNombreLike/{var}")
	@ResponseBody
	public ResponseEntity<?> listaEjemploPorNombreLike(@PathVariable("var") String nombre){
		List<Ejemplo> lstSalida = null;
		if (nombre.equals("todos")) {
			lstSalida =ejemploService.listaEjemplo();
		}else {
			lstSalida =ejemploService.listaEjemploPorDescripcionLike(nombre +  "%");
		}
		return ResponseEntity.ok(lstSalida);
	}
	
	@PostMapping("/registraEjemplo")
	@ResponseBody
	public ResponseEntity<?> insertaEjemplo(@RequestBody Ejemplo obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdEjemplo(0);
			obj.setFechaActualizacion(new Date());
			obj.setFechaRegistro(new Date());
			obj.setEstado(AppSettings.ACTIVO);
			
			Ejemplo objSalida = ejemploService.insertaActualizaEjemplo(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_REG_EXITOSO + " Ejemplo de ID ==> " + obj.getIdEjemplo() + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizaEjemplo")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaEjemplo(@RequestBody Ejemplo obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			
			obj.setFechaActualizacion(new Date());

			Ejemplo objSalida = ejemploService.insertaActualizaEjemplo(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + " Ejemplo de ID ==> " + obj.getIdEjemplo() + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@DeleteMapping("/eliminaEjemplo/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaEjemplo(@PathVariable("id") int idEjemplo) {
		Map<String, Object> salida = new HashMap<>();
		try {
			ejemploService.eliminaEjemplo(idEjemplo);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + " Ejemplo de ID ==> " + idEjemplo + "." );
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/validaDescripcionActualiza")
	public String validaDescripcion(@RequestParam(name = "descripcion")String descripcion,
									@RequestParam(name = "idEjemplo")int idEjemplo) {
		 List<Ejemplo> lstSalida =ejemploService.listaEjemploPorDescripcionIgualActualiza(descripcion, idEjemplo);
		 if (lstSalida.isEmpty()) {
			 return "{\"valid\":true}";
		 }else {
			 return "{\"valid\":false}";
		 }
			
	}
	
	
}
