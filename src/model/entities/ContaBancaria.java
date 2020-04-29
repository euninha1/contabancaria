package model.entities;

import model.DomainException;

public class ContaBancaria {
	private Integer num; 
	private String nome; 
	private Double saldo; 
	private Double limitesaque;
	public ContaBancaria(Integer num, String nome, Double saldo, Double limitesaque) {
		this.num = num;
		this.nome = nome;
		this.saldo = saldo;
		this.limitesaque = limitesaque;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSaldo() {
		return saldo;
	}
	public Double getLimitesaque() {
		return limitesaque;
	} 
	public void setLimitesaque(Double limitesaque) { 
		this.limitesaque = limitesaque; 
	}
	public void deposit(double saque) { 
		saldo += saque; 
	}
	public void retirar(double saque) { 
		if(saque > limitesaque) { 
			throw new DomainException("O valor excede ao limite de retirada"); 
		}
		if( saque > saldo) { 
			throw new DomainException("Saldo insuficiente"); 
		}
		saldo -= saque;
	}
}
