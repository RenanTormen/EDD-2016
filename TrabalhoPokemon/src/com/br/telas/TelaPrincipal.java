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

public class TelaPrincipal extends JFrame{
	
	JPanel panelBotoes = new JPanel();
	GridLayout layoutPanel = new GridLayout(2,2,2,2);
	BorderLayout layoutFrame = new BorderLayout();
	JButton botaoCadastro = new JButton("Cadastrar Pokemon");
	JButton botaoBatalha = new JButton("INICIAR A FODENDO BATALHA");
	JButton botaoMostrarPkmn = new JButton("AMOSTRA AS TRETA TUDO");
	JButton botaoSair = new JButton("ARREGA, SEU BOSTINHA");
	JLabel  labelConfia = new JLabel("TRUNFO DO POKEMAO DO SUCESSO DO J DE CONFIA");
	public void initComponents(){
		setVisible(true);
		layoutFrame.setVgap(10);
		panelBotoes.setLayout(layoutPanel);
		panelBotoes.add(botaoCadastro);
		panelBotoes.add(botaoBatalha);
		panelBotoes.add(botaoMostrarPkmn);
		panelBotoes.add(botaoSair);
		
		Dimension tamanhoMonitor = Toolkit.getDefaultToolkit().getScreenSize();
		labelConfia.setFont(new Font("Chiller", Font.BOLD, 22));
		this.setLayout(layoutFrame);
		this.add(layoutFrame.PAGE_START,labelConfia);
		this.setBounds(0,0, (int)tamanhoMonitor.getWidth()/2, (int)tamanhoMonitor.getHeight()/2);
		this.add(panelBotoes);
		this.repaint();
		//this.pack();
		
	}

	public void initListeners(){
		
		botaoBatalha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPokemon tp = new TelaCadastroPokemon();
				
			}
		});
	}
	
	public static void main(String[] args) {
		TelaPrincipal tl = new TelaPrincipal();
		tl.initComponents();
		tl.initListeners();
	}
}
