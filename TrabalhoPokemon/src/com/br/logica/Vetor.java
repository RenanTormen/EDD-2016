package com.br.logica;

import java.util.Random;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.br.model.*;

public class Vetor {

	private int tamanho;
	private Pokemon[] pkmn = new Pokemon[0];
	private String[] nomes = {"Squirtle","Charmander","Bulbassauro","Mewtwo","Mew","Eeve","Ekans","Dragonite","Jigglypuff","Snorlax"};
	
	public Vetor(){
		vetorPronto();
	}
	
	public void inserePokemon(Pokemon pokemon) {
		tamanho = pkmn.length;
		if (tamanho == 0) {
			pkmn = new Pokemon[tamanho + 1];

			/* System.out.println(tamanho + " - " + pkmn.length); */
			pkmn[0] = pokemon;
			// System.out.println(pkmn[0].getNomePokemon());

			tamanho = pkmn.length;
		} else if (tamanho > 0) {
			Pokemon[] tmp = new Pokemon[tamanho + 1];
			for (int i = 0; i <= tamanho - 1; i++) {
				tmp[i] = pkmn[i];
			}
			tamanho = tmp.length;
			tmp[tamanho - 1] = pokemon;
			pkmn = new Pokemon[tamanho];
			for (int i = 0; i <= tamanho - 1; i++) {
				pkmn[i] = tmp[i];
			}
		}
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public Pokemon retornaPokemon(int i) {

		return this.pkmn[i];
	}

	public void ordenaVetor() {
		int posMenor = 0;

		

		for (int i = 0; i < this.pkmn.length; i++) {
			posMenor = i;
			for (int j = i + 1; j < this.pkmn.length; j++) {
				if (this.pkmn[posMenor].getNumero() > this.pkmn[j].getNumero()) {
					posMenor = j;
				}
				if (posMenor != i) {
					Pokemon aux = pkmn[i];
					pkmn[i] = pkmn[posMenor];
					pkmn[posMenor] = aux;
				}
			}

		}
		mostraVetor();
	}

	public void mostraVetor() {
		for (int o = 0; o < 1000; o++) {
			System.out.println("");
		}
		;

		for (int i = 0; i != this.pkmn.length; i++) {

			/*System.out.println("Nome Pokemon: " + this.pkmn[i].getNomePokemon());
			System.out.println("Numero Pokemon: " + this.pkmn[i].getNumero());*/
			System.out.print("["+this.pkmn[i].getNumero()+"]");
		}

	}

	public void vetorPronto(){
		for(int i = 0; i != nomes.length; i++){
			Pokemon tmp = new Pokemon();
			tmp.setNomePokemon(nomes[i]);
			tmp.setAtaque(new Random().nextInt(5000-0));
			tmp.setAgilidade(new Random().nextInt(5000-0));
			tmp.setDefesa(new Random().nextInt(5000-0));
			tmp.setForca(new Random().nextInt(5000-0));
			tmp.setNumero(i);
			this.inserePokemon(tmp);
		}
		ordenaVetor();
	}
}

