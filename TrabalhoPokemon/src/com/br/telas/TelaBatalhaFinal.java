package com.br.telas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import com.br.model.Player;
import com.br.model.Pokemon;

public class TelaBatalhaFinal extends JFrame {

	private Box player = new Box(BoxLayout.Y_AXIS);
	private JScrollPane scroll = new JScrollPane();
	private int i = 1;
	private JButton botaoProximo = new JButton("Escolher");
	private JRadioButton radioAtk = new JRadioButton("Ataque");
	private JRadioButton radioDef = new JRadioButton("Defesa");
	private JRadioButton radioForc = new JRadioButton("Força");
	private JRadioButton radioAgil = new JRadioButton("Agilidade");
	private ButtonGroup grupo = new ButtonGroup();
	private Box opcoesCompara = new Box(BoxLayout.X_AXIS);
	private int playerRodada = 1;
	TelaBatalhaFinal tela2 = null;

	public TelaBatalhaFinal() {

		initComponents();
		initListeners();
	}

	public void initComponents() {
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new BorderLayout(0, 0));

		grupo.add(radioAgil);
		grupo.add(radioDef);
		grupo.add(radioForc);
		grupo.add(radioAtk);
		grupo.clearSelection();

		opcoesCompara.add(radioAgil);
		opcoesCompara.add(radioDef);
		opcoesCompara.add(radioAtk);
		opcoesCompara.add(radioForc);

		player.add(BorderLayout.CENTER, new JLabel("RODADA: " + i)).setFont(new Font("Arial", Font.BOLD, 20));
		player.add(new JLabel("Player, escolha o Pokemon desta rodada: "));
		player.add(scroll);

		this.add(BorderLayout.CENTER, player);
		this.add(BorderLayout.LINE_END, opcoesCompara);
		this.add(BorderLayout.SOUTH, botaoProximo);
		this.pack();
	}

	public void initListeners() {

		botaoProximo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (playerRodada == 1) {
					scroll = new JScrollPane(TelaPrincipal.player1.getListaEscolhidos());
					scroll.validate();
					pack();
					Pokemon p1Sel = new Pokemon();
					JOptionPane
							.showMessageDialog(null,
									"Player 1, Você escolheu o pokemon: "
											+ TelaPrincipal.player1.getModel()
													.getElementAt(TelaPrincipal.player1.getListaEscolhidos()
															.getSelectedIndex())
													.getNomePokemon()
											+ "Com o atrib: " + checaAtributo());
					p1Sel = TelaPrincipal.player1.getModel()
							.getElementAt(TelaPrincipal.player1.getListaEscolhidos().getSelectedIndex());
					playerRodada = 2;
					dispose();
				}
				if (playerRodada == 2) {
					tela2.scroll = null;
					TelaBatalhaFinal tela2 = new TelaBatalhaFinal();
					tela2.scroll = new JScrollPane(TelaPrincipal.player2.getListaEscolhidos());
					tela2.pack();
					tela2.setVisible(true);

					tela2.botaoProximo.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Pokemon p2Sel = new Pokemon();
							JOptionPane.showMessageDialog(null,
									"Player 2, Você escolheu o pokemon: "
											+ TelaPrincipal.player2.getModel()
													.getElementAt(TelaPrincipal.player2.getListaEscolhidos()
															.getSelectedIndex())
													.getNomePokemon()
											+ "Com o atrib: " + checaAtributo());
							p2Sel = TelaPrincipal.player2.getModel()
									.getElementAt(TelaPrincipal.player2.getListaEscolhidos().getSelectedIndex());
							// playerRodada = 2;

						}
					});
				}
			}
		});
	}

	public int checaAtributo() {
		if (this.radioAgil.isSelected()) {
			return 1;
		}
		if (this.radioDef.isSelected()) {
			return 2;
		}
		if (this.radioAtk.isSelected()) {
			return 3;
		}
		if (this.radioForc.isSelected()) {
			return 4;
		}
		return 0;
	}

}