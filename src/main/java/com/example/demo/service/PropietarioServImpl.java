package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPropietarioRepo;
import com.example.demo.repository.modelo.Propietario;

@Service
public class PropietarioServImpl implements IPropietarioServ {
	@Autowired
	private IPropietarioRepo propietarioRepo;

	@Override
	public Propietario buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.propietarioRepo.seleccionar(id);
	}

	@Override
	public void guardar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.propietarioRepo.insertar(propietario);
	}

	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.propietarioRepo.actualizar(propietario);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.propietarioRepo.eliminar(id);
	}

}
