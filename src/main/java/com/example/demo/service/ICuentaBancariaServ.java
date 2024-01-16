package com.example.demo.service;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaServ {
	public CuentaBancaria buscar(Integer id);

	public void guardar(CuentaBancaria cuentaBancaria);

	public void actualizar(CuentaBancaria cuentaBancaria);

	public void eliminar(Integer id);
	
	
	public CuentaBancaria buscarPorNumero(String numero);

}
