package io.github.xadrezsuico.kit.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HomePanel extends JPanel {
	
	private DefaultView defaultView;

	/**
	 * Create the panel.
	 */
	public HomePanel(DefaultView defaultView) {
		this.defaultView = defaultView;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblBemvindoaAoKit = new JLabel("Bem-vindo(a) ao Kit de Arbitragem de Xadrez");
		lblBemvindoaAoKit.setFont(new Font("Arial", Font.BOLD, 17));
		GridBagConstraints gbc_lblBemvindoaAoKit = new GridBagConstraints();
		gbc_lblBemvindoaAoKit.gridwidth = 5;
		gbc_lblBemvindoaAoKit.insets = new Insets(0, 0, 5, 0);
		gbc_lblBemvindoaAoKit.gridx = 0;
		gbc_lblBemvindoaAoKit.gridy = 0;
		add(lblBemvindoaAoKit, gbc_lblBemvindoaAoKit);
		
		JLabel lblOPresenteKit = new JLabel("O presente kit faz parte do projeto \"XadrezSu\u00ED\u00E7o\", projeto para o desenvolvimento de sistema de gerenciamento de torneios de xadrez.");
		GridBagConstraints gbc_lblOPresenteKit = new GridBagConstraints();
		gbc_lblOPresenteKit.anchor = GridBagConstraints.NORTH;
		gbc_lblOPresenteKit.gridwidth = 5;
		gbc_lblOPresenteKit.insets = new Insets(0, 0, 0, 5);
		gbc_lblOPresenteKit.gridx = 0;
		gbc_lblOPresenteKit.gridy = 1;
		add(lblOPresenteKit, gbc_lblOPresenteKit);

	}

}
