package com.br.telas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.br.model.Player;
import com.br.model.Pokemon;

public class TelaBatalhaPlayer extends JFrame {

	private int maxPokemon = 0;
	private JTextField fieldNome = new JTextField();
	private JTextField fieldAtk = new JTextField();
	private JTextField fieldDef = new JTextField();
	private JTextField fieldAgil = new JTextField();
	private JTextField fieldForca = new JTextField();
	private JComboBox jComboPkmn = new JComboBox();
	private DefaultListModel<Pokemon> model = new DefaultListModel<Pokemon>();
	private JList listaEscolhidos = new JList();
	private JScrollPane sPane = new JScrollPane(listaEscolhidos);
	private JButton botaoEscolhe = new JButton("Escolher Pokemon");
	private JButton botaoConfirma = new JButton("Confirmar lista de Pokemons");
	private JPanel panel1 = new JPanel();
	private Box boxEscolha = new Box(BoxLayout.Y_AXIS);
	private Box boxFields = new Box(BoxLayout.Y_AXIS); 
	private Box boxLista = new Box(BoxLayout.Y_AXIS);
	
	
	public TelaBatalhaPlayer() {
		populaCoisas();
		initComponents();
		initListeners();
		 
	}
	public void setPlayers(){
		for(int i = 0; i != 2; i++){
			Player player1 = new Player();
			player1.insere(pokemon);
		}
		
	}

	
	public void initComponents() {
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(1,2));
		
		
		boxFields.add(new JLabel("Nome do Pokemon: "));
		boxFields.add(fieldNome);
		boxFields.add(new JLabel("Ataque: "));
		boxFields.add(fieldAtk);
		boxFields.add(new JLabel("Defesa: "));
		boxFields.add(fieldDef);
		boxFields.add(new JLabel("Agilidade: "));
		boxFields.add(fieldAgil);
		boxFields.add(new JLabel("Força: "));
		boxFields.add(fieldForca);
		
		
		boxEscolha.add(jComboPkmn);
		boxEscolha.add(botaoEscolhe);
		
		panel1.setLayout(new GridLayout(2, 1));
		panel1.add(boxEscolha);
		panel1.add(boxFields);

		boxLista.add(sPane);
		boxLista.add(botaoConfirma);
		
		this.add(panel1);
		this.add(boxLista);
		this.pack();
	}

	public void initListeners() {

		botaoEscolhe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(maxPokemon < 3){
				maxPokemon += 1;
			//	System.out.println(jComboPkmn.getSelectedItem());
				model.addElement((Pokemon) jComboPkmn.getSelectedItem());
				player.insere((Pokemon) jComboPkmn.getSelectedItem());
				} else {
					JOptionPane.showMessageDialog(null, "Já foi selecionado o máximo de pokemons possíveis");
				}
			}
		});
			
		jComboPkmn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Pokemon tmpPk = new Pokemon();
				tmpPk = (Pokemon)jComboPkmn.getSelectedItem();
				fieldAgil.setText(String.valueOf(tmpPk.getAgilidade()));
				fieldDef.setText(String.valueOf(tmpPk.getDefesa()));
				fieldAtk.setText(String.valueOf(tmpPk.getAtaque()));
				fieldNome.setText(tmpPk.getNomePokemon());
				fieldForca.setText(String.valueOf(tmpPk.getForca()));
				
			}
		});
		
	}
	
	public void populaCoisas(){
		listaEscolhidos.setModel(model);
		for(int i = 0; i != TelaPrincipal.pokemao.getTamanho(); i++){
		this.jComboPkmn.addItem(TelaPrincipal.pokemao.retornaPokemon(i));
		}
		
	}
	

}
