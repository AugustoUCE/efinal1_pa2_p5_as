package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="transferencia")
public class Transferencia {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transferencia")
	@SequenceGenerator(name = "seq_transferencia", sequenceName = "seq_transferencia", allocationSize = 1)
	@Column(name="tran_id")
	private Integer id;
	@Column(name="tran_fecha")
	private LocalDateTime fecha;
	
	
	@Column(name="tran_cuentaBancariaO")
	private CuentaBancaria cuentaBancariaO;
	
	@Column(name="tran_cuentaBancariaD")
	private CuentaBancaria cuentaBancariaD;
	@Column(name="tran_monto")
	private BigDecimal monto;
	@Column(name="tran_comision")
	private BigDecimal comision;
	
	@OneToOne(mappedBy ="cuentaBancaria",cascade = CascadeType.ALL )
	@JoinColumn(name="trans_id_cta")
	private CuentaBancaria cuentaBancaria;
	
	
	
	public BigDecimal getComision() {
		return comision;
	}
	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public CuentaBancaria getCuentaBancariaO() {
		return cuentaBancariaO;
	}
	public void setCuentaBancariaO(CuentaBancaria cuentaBancariaO) {
		this.cuentaBancariaO = cuentaBancariaO;
	}
	public CuentaBancaria getCuentaBancariaD() {
		return cuentaBancariaD;
	}
	public void setCuentaBancariaD(CuentaBancaria cuentaBancariaD) {
		this.cuentaBancariaD = cuentaBancariaD;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	
	
	
	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}
	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", fecha=" + fecha + ", cuentaBancariaO=" + cuentaBancariaO
				+ ", cuentaBancariaD=" + cuentaBancariaD + ", monto=" + monto + ", comision=" + comision + "]";
	}
	
		
	
	
	
	
	
	

}
