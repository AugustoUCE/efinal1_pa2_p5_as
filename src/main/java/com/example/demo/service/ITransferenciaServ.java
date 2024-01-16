package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Transferencia;

public interface ITransferenciaServ {
	
	public void guardar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	
	public List<Transferencia> buscarTodo();

	public void transferencia(String numeroCtaOrigen,String numeroCtaDestino,BigDecimal monto);
}
