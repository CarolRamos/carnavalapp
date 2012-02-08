package com.uglyboys.canavalapp.config;

import java.util.ArrayList;
import java.util.List;

public class Circuito {
	
	private String circuitoNome = "";
	private List<CircuitoDia> dias = new ArrayList<CircuitoDia>();
	
	public Circuito(){
	}
	
	public String getNome() {
		return circuitoNome;
	}

	public void setNome(String nome) {
		this.circuitoNome = nome;
	}

	public List<CircuitoDia> getDias() {
		return dias;
	}

	public void setDias(List<CircuitoDia> dias) {
		this.dias = dias;
	}

}
