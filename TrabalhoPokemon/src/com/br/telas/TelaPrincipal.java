package com.br.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import com.br.logica.Vetor;
import com.br.model.Player;

public class TelaPrincipal extends JFrame {

	public static Vetor pokemao = new Vetor();
	public static TelaBatalhaFinal batalha = null;
	public static TelaBatalhaPlayer player1 = null;
	public static TelaBatalhaPlayer player2 = null;
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
				
				if (!(player1 instanceof TelaBatalhaPlayer)) {
					player1 = new TelaBatalhaPlayer();
					player2 = new TelaBatalhaPlayer();
					player2.setVisible(false);
					checkPronto();

					if (!player1.isPronto()) {
						player1.addWindowListener(new WindowListener() {

							@Override
							public void windowOpened(WindowEvent e) {
								JOptionPane.showMessageDialog(null, "Player 1, escolha seus pokemons");

							}

							@Override
							public void windowIconified(WindowEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void windowDeiconified(WindowEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void windowDeactivated(WindowEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void windowClosing(WindowEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void windowClosed(WindowEvent e) {
								JOptionPane.showMessageDialog(null, "Player 2 Escolha seus Pokemons");
								player2.setVisible(true);
							
							}

							@Override
							public void windowActivated(WindowEvent e) {
								// TODO Auto-generated method stub

							}

						});

					}

				} else {
					checkPronto();
					botaoBatalha.getAction();
				}
			}
		});

	}
	
	public void checkPronto(){
		if(player1.isPronto() && player2.isPronto()){
			TelaBatalhaFinal batalha = new TelaBatalhaFinal();
			JOptionPane.showMessageDialog(null, "HORA DA BATALHA");
			batalha.setVisible(true);	
		}
	}

	public static void main(String[] args) {
		TelaPrincipal tl = new TelaPrincipal();
		tl.initComponents();
		tl.initListeners();
	}
}
