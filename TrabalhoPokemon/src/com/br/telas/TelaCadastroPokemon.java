package com.br.telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import com.br.model.Pokemon;

public class TelaCadastroPokemon extends JFrame {

	private JButton botaoCad = new JButton("Cadastrar pokemon");
	private JButton botaoLimpar = new JButton("Limpar dados");
	private JTextField fieldNome = new JTextField();
	private JTextField fieldAtk = new JTextField();
	private JTextField fieldDef = new JTextField();
	private JTextField fieldAgil = new JTextField();
	private JTextField fieldForca = new JTextField();
	private Box panelTxt = new Box(BoxLayout.Y_AXIS);
	private Box layoutFrame = new Box(BoxLayout.Y_AXIS);
	private JLabel labelTitulo = new JLabel("Cadastro de pokemons: ");
	private JPanel panelBtn = new JPanel();
	
	public TelaCadastroPokemon(){
		initComponents();
		initListeners();
		
	}
	
	public void initComponents() {
		setVisible(true);
		setLayout(new BorderLayout());
		
		panelTxt.add(new JLabel("Nome: "));
		panelTxt.add(fieldNome);

		panelTxt.add(new JLabel("Ataque: "));
		panelTxt.add(fieldAtk);

		panelTxt.add(new JLabel("Defesa: "));
		panelTxt.add(fieldDef);

		panelTxt.add(new JLabel("Agilidade: "));
		panelTxt.add(fieldAgil);
		
		panelTxt.add(new JLabel("Força: "));
		panelTxt.add(fieldForca);
		
		
		panelBtn.add(botaoCad);
		panelBtn.add(botaoLimpar);
		
		layoutFrame.add(panelTxt);
		layoutFrame.add(panelBtn);
		
		add(BorderLayout.CENTER,layoutFrame);
		setLocationRelativeTo(null);
		repaint();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();

	}
	
	public void initListeners(){
		
	  botaoCad.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Pokemon pkmnTemp = new Pokemon();
			
			
			pkmnTemp.setNomePokemon(fieldNome.getText());
			pkmnTemp.setAgilidade(Integer.parseInt(fieldAgil.getText()));
			pkmnTemp.setAtaque(Integer.parseInt(fieldAtk.getText()));
			pkmnTemp.setDefesa(Integer.parseInt(fieldDef.getText()));
			pkmnTemp.setForca(Integer.parseInt(fieldForca.getText()));
			pkmnTemp.setNumero(verificaNumero());
			
			TelaPrincipal.pokemao.inserePokemon(pkmnTemp);
			TelaPrincipal.pokemao.ordenaVetor();
		}
	});
		
	}
	public int verificaNumero(){
		int numpk = new Random().nextInt(10000-0);
		for(int i = 0; i != TelaPrincipal.pokemao.getTamanho(); i++){
			if(TelaPrincipal.pokemao.retornaPokemon(i).getNumero() == numpk){
				numpk = new Random().nextInt(100-0);
				return numpk;
			} 
		}
		return numpk;
	}
}
