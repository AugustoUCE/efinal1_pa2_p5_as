package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Transferencia;

public interface ITransferenciaRepo {
	
	public void insertar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	
	public List<Transferencia> seleccionarTodo();

}
