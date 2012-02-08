package com.uglyboys.canavalapp.config;

import java.util.ArrayList;
import java.util.List;

public class CircuitoDia {
	
	private String nomeCircuitoDia = "";
	private List<Atracao> atracoes = new ArrayList<Atracao>();
	
	public CircuitoDia(){
	}

	public String getNomeCircuitoDia() {
		return nomeCircuitoDia;
	}

	public void setNomeCircuitoDia(String nomeCircuitoDia) {
		this.nomeCircuitoDia = nomeCircuitoDia;
	}

	public List<Atracao> getAtracoes() {
		return atracoes;
	}

	public void setAtracoes(List<Atracao> atracoes) {
		this.atracoes = atracoes;
	}
	
}
