package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.Opcion;
import com.prestamo.entity.Rol;
import com.prestamo.entity.Usuario;

public interface UsuarioService {

	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

	public abstract Usuario buscaPorLogin(String login);

	public abstract List<Usuario> listaJefePrestamistaTotales();

	public abstract List<Usuario> listaPrestamistaDeUnJefe(int idUsuario);

	public abstract List<Usuario> listaPrestamistariosDeUnPrestamista(int idUsuario);

}
