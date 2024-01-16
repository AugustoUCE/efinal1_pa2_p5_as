package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICuentaBancariaRepo;
import com.example.demo.repository.ITransferenciaRepo;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServImpl implements ITransferenciaServ {
	@Autowired
	private ITransferenciaRepo transferenciaRepo;
	
	@Autowired
	private ICuentaBancariaRepo cuentaBancariaRepo;

	@Override
	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.transferenciaRepo.insertar(transferencia);
	}
	
	@Override
	public List<Transferencia> buscarTodo() {
		// TODO Auto-generated method stub
		return this.transferenciaRepo.seleccionarTodo();
	}

	@Override
	public void transferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		CuentaBancaria ctaO = this.cuentaBancariaRepo.seleccionarPorNumero(numeroCtaOrigen);
		
		if (ctaO.getSaldo().compareTo(monto)>= 0) {
			BigDecimal saldo=ctaO.getSaldo();
			BigDecimal comision= monto.multiply(new BigDecimal(0.10));
			BigDecimal resta=saldo.subtract(monto);
			BigDecimal restaF=resta.subtract(comision);
			ctaO.setSaldo(restaF);
			this.cuentaBancariaRepo.actualizar(ctaO);
			
			CuentaBancaria ctaD = this.cuentaBancariaRepo.seleccionarPorNumero(numeroCtaDestino);
			
			BigDecimal saldoDestino=ctaD.getSaldo();
			BigDecimal saldoNuevo = saldoDestino.add(monto);
			ctaD.setSaldo(saldoNuevo);
			this.cuentaBancariaRepo.actualizar(ctaD);
			
			Transferencia t = new Transferencia();
			t.setComision(comision);
			t.setCuentaBancariaO(ctaO);
			t.setCuentaBancariaD(ctaD);
			t.setFecha(LocalDateTime.now());
			t.setMonto(monto);
			t.setComision(comision);
			
			this.transferenciaRepo.insertar(t);

		} else {
			System.out.println("Sin saldo");

		}
		
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.transferenciaRepo.actualizar(transferencia);
	}



	

}
