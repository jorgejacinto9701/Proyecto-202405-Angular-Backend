package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Ejemplo;

public interface EjemploService {

	public abstract Ejemplo insertaActualizaEjemplo(Ejemplo obj);
	public abstract List<Ejemplo> listaEjemplo();
	public abstract List<Ejemplo> listaEjemploPorDescripcionIgual(String descripcion);
}
