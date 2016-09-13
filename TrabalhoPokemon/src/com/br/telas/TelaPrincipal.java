package com.br.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.br.logica.Vetor;

public class TelaPrincipal extends JFrame {

	public static Vetor pokemao = new Vetor();
	private JPanel panelBotoes = new JPanel();
	private GridLayout layoutPanel = new GridLayout(2, 2, 2, 2);
	private BorderLayout layoutFrame = new BorderLayout();
	private JButton botaoCadastro = new JButton("Cadastrar Pokemon");
	private JButton botaoBatalha = new JButton("INICIAR A BATALHA");
	private JButton botaoMostrarPkmn = new JButton("POKEDEX");
	private JButton botaoSair = new JButton("SAIR DO JOGO");
	private JLabel labelConfia = new JLabel("TRUNFO DO POKEMON - TRABALHO 3 BIMESTRE");

	public void initComponents() {
		setVisible(true);
		setLocationRelativeTo(null);
		layoutFrame.setVgap(10);
		panelBotoes.setLayout(layoutPanel);
		panelBotoes.add(botaoCadastro);
		panelBotoes.add(botaoBatalha);
		panelBotoes.add(botaoMostrarPkmn);
		panelBotoes.add(botaoSair);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension tamanhoMonitor = Toolkit.getDefaultToolkit().getScreenSize();
		labelConfia.setFont(new Font("Chiller", Font.BOLD, 22));
		this.setLayout(layoutFrame);
		this.add(layoutFrame.PAGE_START, labelConfia);
		// this.setBounds(0, 0, (int) tamanhoMonitor.getWidth() / 2, (int)
		// tamanhoMonitor.getHeight() / 2);
		this.add(panelBotoes);
		// this.repaint();
		this.pack();

	}

	public void initListeners() {

		botaoCadastro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPokemon tl = new TelaCadastroPokemon();

			}
		});
		
		botaoMostrarPkmn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaPokedex dex = new TelaPokedex();
				
			}
		});
		
		botaoBatalha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaBatalhaPlayer player1 = new TelaBatalhaPlayer();
				
			}
		});
	}
	
		
	public static void main(String[] args) {
		TelaPrincipal tl = new TelaPrincipal();
		tl.initComponents();
		tl.initListeners();
	}
}
