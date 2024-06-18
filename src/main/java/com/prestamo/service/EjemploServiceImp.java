package com.prestamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.Ejemplo;
import com.prestamo.repository.EjemploRepository;

@Service
public class EjemploServiceImp implements EjemploService {

	@Autowired	
	private EjemploRepository repository;

	@Override
	public Ejemplo insertaActualizaEjemplo(Ejemplo obj) {
		return repository.save(obj);
	}
	
	@Override
	public List<Ejemplo> listaEjemplo() {
		return repository.findAll();
	}

	@Override
	public List<Ejemplo> listaEjemploPorDescripcionIgual(String descripcion) {
		return repository.listaEjemploPorDescripcionIgual(descripcion);
	}

	@Override
	public List<Ejemplo> listaEjemploPorDescripcionLike(String nombre) {
		return repository.listaEjemploPorDescripcionLike(nombre);
	}

	@Override
	public void eliminaEjemplo(int idRevista) {
		repository.deleteById(idRevista);
	}

	@Override
	public List<Ejemplo> listaEjemploPorDescripcionIgualActualiza(String descripcion, int idEjemplo) {
		return repository.listaEjemploPorDescripcionIgualActualiza(descripcion, idEjemplo);
	}
	
}
