package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Ejemplo;

public interface EjemploRepository extends JpaRepository<Ejemplo, Integer>{
	
	
	@Query("select e from Ejemplo e where e.descripcion = ?1")
	public abstract List<Ejemplo> listaEjemploPorDescripcionIgual(String descripcion);

}
