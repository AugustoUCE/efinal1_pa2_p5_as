package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.ICuentaBancariaServ;
import com.example.demo.service.ITransferenciaServ;

@SpringBootApplication
public class Efinal1Pa2P5AsApplication implements CommandLineRunner {
	
	@Autowired
	private ICuentaBancariaServ cuentaBancariaServ;
	
	@Autowired
	private ITransferenciaServ transferenciaServ;

	public static void main(String[] args) {
		SpringApplication.run(Efinal1Pa2P5AsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		CuentaBancaria cta = new CuentaBancaria();
		cta.setNumero("12");
		cta.setSaldo(new BigDecimal(10));
		cta.setTipo("a");

		Propietario p = new Propietario();
		p.setApellido("salazar");
		p.setCedula("345");
		p.setNombre("paco");
		p.setCuentaBancaria(cta);
		
		cta.setPropietario(p);
		
		CuentaBancaria cta1 = new CuentaBancaria();
		cta1.setNumero("12");
		cta1.setSaldo(new BigDecimal(10));
		cta1.setTipo("a");

		Propietario p1 = new Propietario();
		p1.setApellido("salazar");
		p1.setCedula("345");
		p1.setNombre("paco");
		p1.setCuentaBancaria(cta);
		cta1.setPropietario(p1);
		
		this.cuentaBancariaServ.guardar(cta);
		
		this.transferenciaServ.transferencia("12", "345", new BigDecimal(10));
		this.transferenciaServ.buscarTodo();
		
		
	}

}
