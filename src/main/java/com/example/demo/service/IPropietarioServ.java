package com.example.demo.service;

import com.example.demo.repository.modelo.Propietario;

public interface IPropietarioServ {
	
	
	public Propietario buscar(Integer id);
	public void guardar(Propietario propietario);
	public void actualizar(Propietario propietario);
	public void eliminar(Integer id);

}
