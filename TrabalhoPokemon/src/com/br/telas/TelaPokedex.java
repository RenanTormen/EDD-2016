package com.br.telas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.br.model.Pokemon;

public class TelaPokedex extends JFrame {

	public TelaPokedex() {
		initComponents();
		populaJlistPkmn();
		initListeners();
	}

	private Box panelNomes = new Box(BoxLayout.X_AXIS);
	private JList listaNomes = new JList<>();
	private JScrollPane scrollLista = new JScrollPane(listaNomes);
	private Box panelDados = new Box(BoxLayout.Y_AXIS);
	private JTextField fieldNome = new JTextField();
	private JTextField fieldAtk = new JTextField();
	private JTextField fieldDef = new JTextField();
	private JTextField fieldAgil = new JTextField();
	private JTextField fieldForca = new JTextField();
	private DefaultListModel<Pokemon> model = new DefaultListModel<Pokemon>();
	private GridLayout layoutFrame = new GridLayout(1, 2);
	
	public void initComponents() {
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(layoutFrame);
		
		panelDados.add(new JLabel("Nome do Pokemon: "));
		panelNomes.add(scrollLista);
		panelDados.add(fieldNome);
		panelDados.add(new JLabel("Ataque: "));
		panelDados.add(fieldAtk);
		panelDados.add(new JLabel("Defesa: "));
		panelDados.add(fieldDef);
		panelDados.add(new JLabel("Agilidade: "));
		panelDados.add(fieldAgil);
		panelDados.add(new JLabel("Força: "));
		panelDados.add(fieldForca);
		
		this.add(panelNomes);
		this.add(panelDados);
		this.pack();

	}

	public void populaJlistPkmn() {
		TelaPrincipal.pokemao.ordenaVetor();
		for(int i = 0; i != TelaPrincipal.pokemao.getTamanho(); i++){
		model.add(i,TelaPrincipal.pokemao.retornaPokemon(i));
		}
		listaNomes.setModel(model);
	}
	public void initListeners(){
		
		listaNomes.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				fieldAgil.setText(String.valueOf(TelaPrincipal.pokemao.retornaPokemon(listaNomes.getSelectedIndex()).getAgilidade()));
				fieldAtk.setText(String.valueOf(TelaPrincipal.pokemao.retornaPokemon(listaNomes.getSelectedIndex()).getAtaque()));
				fieldDef.setText(String.valueOf(TelaPrincipal.pokemao.retornaPokemon(listaNomes.getSelectedIndex()).getDefesa()));
				fieldForca.setText(String.valueOf(TelaPrincipal.pokemao.retornaPokemon(listaNomes.getSelectedIndex()).getForca()));
				fieldNome.setText(TelaPrincipal.pokemao.retornaPokemon(listaNomes.getSelectedIndex()).getNomePokemon());
			}
		});
	}
}