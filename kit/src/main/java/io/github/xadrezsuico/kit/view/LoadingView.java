package io.github.xadrezsuico.kit.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Insets;

public class LoadingView extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public LoadingView() {
		setResizable(false);
		setAutoRequestFocus(false);
		setTitle("CARREGANDO...");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 138);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblCarregando = new JLabel("CARREGANDO...");
		lblCarregando.setFont(new Font("Arial", Font.BOLD, 26));
		GridBagConstraints gbc_lblCarregando = new GridBagConstraints();
		gbc_lblCarregando.insets = new Insets(0, 0, 5, 0);
		gbc_lblCarregando.gridwidth = 13;
		gbc_lblCarregando.gridx = 0;
		gbc_lblCarregando.gridy = 0;
		contentPane.add(lblCarregando, gbc_lblCarregando);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 5, 0);
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.gridwidth = 13;
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 1;
		contentPane.add(progressBar, gbc_progressBar);
		
		JLabel lblPorFavorAguarde = new JLabel("Por favor, aguarde. A p\u00E1gina est\u00E1 sendo gerada...");
		GridBagConstraints gbc_lblPorFavorAguarde = new GridBagConstraints();
		gbc_lblPorFavorAguarde.gridwidth = 13;
		gbc_lblPorFavorAguarde.insets = new Insets(0, 0, 0, 5);
		gbc_lblPorFavorAguarde.gridx = 0;
		gbc_lblPorFavorAguarde.gridy = 2;
		contentPane.add(lblPorFavorAguarde, gbc_lblPorFavorAguarde);
	}

}
