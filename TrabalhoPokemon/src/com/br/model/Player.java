package com.br.model;

import java.util.ArrayList;

public class Player {

	private ArrayList<Pokemon> selecaoPokemons = new ArrayList<>();
	private boolean pronto = false;

	public boolean isPronto() {
		return pronto;
	}

	public void setPronto(boolean pronto) {
		this.pronto = pronto;
	}

	public Player() {
		ordenaInsercao();
	}

	public void insere(Pokemon pokemon) {
		this.selecaoPokemons.add(pokemon);
		ordenaInsercao();
		mostraLista();
	}

	public void remove(Pokemon pokemon) {

	}

	public void ordenaInsercao() {
		int j = 0;
		
		for (int i = 1; i < this.selecaoPokemons.size(); i++) {
			Pokemon chave = this.selecaoPokemons.get(i);
			
			for (j = i - 1; j >= 0 && this.selecaoPokemons.get(j).getNumero() > chave.getNumero(); j--) {
				this.selecaoPokemons.set(j+1, this.selecaoPokemons.get(j));
				System.out.println(j);
			}
			this.selecaoPokemons.set(j+1, chave);
		}
		
	}

	public void mostraLista() {
		for (Pokemon pkmn : this.selecaoPokemons) {
			System.out.println(pkmn);
		}
	}

}
