package com.br.telas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelaPrincipal {

	static JLabel labelConfia = new JLabel("HAI");
	
	public static void main(String[] args)  {
		JFrame frame1 = new JFrame("Cadastro de Alunos");
		JPanel panelDados = new JPanel();
		JTextField fieldTexto = new JTextField();
		JButton botaoAmostra = new JButton("CLICA AE VACILAO");
		botaoAmostra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "VOCE DIGITOU VACILADAMENTE: "+fieldTexto.getText());
				
			}
		});
		
		panelDados.setLayout(new GridLayout(2, 0));

		panelDados.add(new JLabel("Nome: "));
		panelDados.add(fieldTexto);
		
		
		
		frame1.setLayout(new BorderLayout());

		frame1.add(panelDados);
		frame1.add(BorderLayout.PAGE_END,botaoAmostra);
		frame1.setLocationRelativeTo(null);
		frame1.pack();
		frame1.setVisible(true);

		
	}

}
