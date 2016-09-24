package com.br.model;

import java.util.ArrayList;

public class Rodadas {
	
	private ArrayList<Rodadas> rd = new ArrayList<Rodadas>();
	private int rodada;
	private Player vencedor;
	
	public void adicionaRodada(Player vencedor){
		this.rodada += 1;
		this.vencedor = vencedor;
		this.rd.add(this);
	}
}
