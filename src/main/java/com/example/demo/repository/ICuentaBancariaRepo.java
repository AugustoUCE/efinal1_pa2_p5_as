package com.example.demo.repository;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepo {
	
	public CuentaBancaria seleccionar(Integer id);
	public void insertar(CuentaBancaria cuentaBancaria);
	public void actualizar(CuentaBancaria cuentaBancaria);
	public void eliminar(Integer id);
	
	public CuentaBancaria seleccionarPorNumero(String numero);

}
