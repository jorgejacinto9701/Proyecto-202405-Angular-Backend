package com.prestamo.util;

public class AppSettings {

	public static final String URL_CROSS_ORIGIN = "http://localhost:4200";
	
	public static final int CATALOGO_01_TIPO_DE_ENDIDAD_BANCARIA = 1;
	public static final int CATALOGO_02_TIPO_DE_MONEDA = 2;
	public static final int CATALOGO_03_DIAS_DE_PRESTAMO = 3;
	public static final int CATALOGO_04_ESTADO_SOLICTUD_DE_PRESTAMO = 4;
	
	public static final int ACTIVO = 1;
	public static final int INACTIVO = 0;
	
	public static final String MENSAJE_REG_YA_EXISTE = "Ya existe dicho registro.";
	public static final String MENSAJE_REG_ERROR = "No se registró, consulte con el administrador.";
	public static final String MENSAJE_REG_EXITOSO = "Se registró correctamente.";
		
	public static final String MENSAJE_ACT_YA_EXISTE = "Ya existe dicho registro.";
	public static final String MENSAJE_ACT_ERROR = "No se actualizó, consulte con el administrador.";
	public static final String MENSAJE_ACT_EXITOSO = "Se actualizó correctamente.";
	public static final String MENSAJE_ACT_NO_EXISTE_ID = "No existe el ID que se desea actualizar.";
	
	public static final String MENSAJE_ELI_ERROR = "No se eliminó, ya que el registro esta relacionado.";
	public static final String MENSAJE_ELI_EXITOSO = "Se eliminó correctamente.";
	public static final String MENSAJE_ELI_NO_EXISTE_ID = "No existe el ID que se desea eliminar.";
	
	public static final String MENSAJE_DNI_YA_EXISTE = "Ya existe dicho el DNI : ";
}
