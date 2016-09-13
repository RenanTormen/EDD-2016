package com.br.model;

public class Pokemon {

	private int numero;
	private String nomePokemon;
	private int forca;
	private int ataque;
	private int defesa;
	private int agilidade;

	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNomePokemon() {
		return nomePokemon;
	}

	public void setNomePokemon(String nomePokemon) {
		this.nomePokemon = nomePokemon;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public int getAgilidade() {
		return agilidade;
	}

	public void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}
	@Override
	public String toString(){
		
		return this.getNumero()+" - "+this.getNomePokemon();
	}

}
