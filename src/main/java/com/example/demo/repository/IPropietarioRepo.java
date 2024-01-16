package com.example.demo.repository;

import com.example.demo.repository.modelo.Propietario;

public interface IPropietarioRepo {
	
	public Propietario seleccionar(Integer id);
	public void insertar(Propietario propietario);
	public void actualizar(Propietario propietario);
	public void eliminar(Integer id);

}
