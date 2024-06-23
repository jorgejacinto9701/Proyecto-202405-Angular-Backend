package com.prestamo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.Ejemplo;

public interface EjemploRepository extends JpaRepository<Ejemplo, Integer>{
	
	
	@Query("select e from Ejemplo e where e.descripcion = ?1")
	public abstract List<Ejemplo> listaEjemploPorDescripcionIgual(String descripcion);

	@Query("select e from Ejemplo e where e.descripcion like ?1")
	public abstract List<Ejemplo> listaEjemploPorDescripcionLike(String descripcion);
	
	@Query("select e from Ejemplo e where e.descripcion = ?1 and e.idEjemplo != ?2 ")
	public abstract List<Ejemplo> listaEjemploPorDescripcionIgualActualiza(String descripcion, int idEjemplo);
	
	@Query("select e from Ejemplo e where "
								+ " e.descripcion like ?1  and "
								+ " (?2 = -1 or e.pais.idPais = ?2) and"
								+ " e.estado = ?3 and "
								+ " (?4 = -1 or e.longitud = ?4 ) and "
								+ " (?5 = -1 or e.dias.idDataCatalogo = ?5) ")
	public abstract List<Ejemplo> listaConsultaCompleja(String descripcion, int idPais, int estado, BigDecimal longitud, int idDias);
	
}
