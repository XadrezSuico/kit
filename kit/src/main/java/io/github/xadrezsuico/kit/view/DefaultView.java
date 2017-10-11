package io.github.xadrezsuico.kit.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.github.xadrezsuico.kit.Main;

import javax.swing.JTabbedPane;

public class DefaultView extends JFrame {
	
	private Main main;
	
	private JPanel contentPane;
	
	private HomePanel homePanel;
	private ConfiguracaoPanel configuracaoPanel;
	private ListaPresencaPanel listaPresencaPanel;

	/**
	 * Create the frame.
	 */
	public DefaultView(Main main) {
		this.main = main;
		setTitle("KIT DE ARBITRAGEM DE XADREZ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		homePanel = new HomePanel(this);
		tabbedPane.add("HOME", homePanel);
		tabbedPane.setSelectedComponent(homePanel);

		listaPresencaPanel = new ListaPresencaPanel();
		tabbedPane.add("LISTA DE PRESENÇA", listaPresencaPanel);
		
		configuracaoPanel = new ConfiguracaoPanel(this);
		tabbedPane.add("CONFIGURAÇÕES", configuracaoPanel);
	}

	
	public Main getMain(){
		return this.main;
	}
}
