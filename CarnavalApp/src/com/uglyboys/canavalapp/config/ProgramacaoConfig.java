package com.uglyboys.canavalapp.config;

import java.util.ArrayList;
import java.util.List;

public class ProgramacaoConfig {
	
	private List<Circuito> circuitos = new ArrayList<Circuito>();
	
	public ProgramacaoConfig(){
	}

	public List<Circuito> getCircuitos() {
		return circuitos;
	}

	public void setCircuitos(List<Circuito> circuitos) {
		this.circuitos = circuitos;
	}
}
