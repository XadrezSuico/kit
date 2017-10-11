package io.github.xadrezsuico.kit.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import io.github.xadrezsuico.kit.enums.TipoLista;
import javax.swing.JButton;

public class ListaPresencaPanel extends JPanel {
	private JTextField tf_linhas;

	/**
	 * Create the panel.
	 */
	public ListaPresencaPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblAquiVocPode = new JLabel("Aqui voc\u00EA pode efetuar as configura\u00E7\u00F5es e imprimir a lista de presen\u00E7a da reuni\u00E3o t\u00E9cnica.");
		GridBagConstraints gbc_lblAquiVocPode = new GridBagConstraints();
		gbc_lblAquiVocPode.insets = new Insets(0, 0, 5, 0);
		gbc_lblAquiVocPode.gridx = 0;
		gbc_lblAquiVocPode.gridy = 0;
		add(lblAquiVocPode, gbc_lblAquiVocPode);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTipoDeLista = new JLabel("Tipo de Lista de Presen\u00E7a:");
		GridBagConstraints gbc_lblTipoDeLista = new GridBagConstraints();
		gbc_lblTipoDeLista.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeLista.anchor = GridBagConstraints.EAST;
		gbc_lblTipoDeLista.gridx = 0;
		gbc_lblTipoDeLista.gridy = 0;
		panel.add(lblTipoDeLista, gbc_lblTipoDeLista);
		
		JComboBox cb_tipo = new JComboBox(TipoLista.values());
		GridBagConstraints gbc_cb_tipo = new GridBagConstraints();
		gbc_cb_tipo.gridwidth = 5;
		gbc_cb_tipo.insets = new Insets(0, 0, 5, 5);
		gbc_cb_tipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_tipo.gridx = 1;
		gbc_cb_tipo.gridy = 0;
		panel.add(cb_tipo, gbc_cb_tipo);
		
		JLabel lblQuantidadeDeLinhas = new JLabel("Quantidade de Linhas:");
		GridBagConstraints gbc_lblQuantidadeDeLinhas = new GridBagConstraints();
		gbc_lblQuantidadeDeLinhas.anchor = GridBagConstraints.EAST;
		gbc_lblQuantidadeDeLinhas.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidadeDeLinhas.gridx = 0;
		gbc_lblQuantidadeDeLinhas.gridy = 1;
		panel.add(lblQuantidadeDeLinhas, gbc_lblQuantidadeDeLinhas);
		
		tf_linhas = new JTextField();
		GridBagConstraints gbc_tf_linhas = new GridBagConstraints();
		gbc_tf_linhas.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_linhas.gridwidth = 5;
		gbc_tf_linhas.insets = new Insets(0, 0, 5, 5);
		gbc_tf_linhas.anchor = GridBagConstraints.NORTH;
		gbc_tf_linhas.gridx = 1;
		gbc_tf_linhas.gridy = 1;
		panel.add(tf_linhas, gbc_tf_linhas);
		tf_linhas.setColumns(10);
		
		JLabel lblLinhas = new JLabel("Caso o tipo de lista de presen\u00E7a seja do tipo 'PR\u00C9-PREENCHIDO', o n\u00FAmero de linhas ser\u00E1 desconsiderado.");
		GridBagConstraints gbc_lblLinhas = new GridBagConstraints();
		gbc_lblLinhas.insets = new Insets(0, 0, 5, 5);
		gbc_lblLinhas.gridwidth = 6;
		gbc_lblLinhas.gridx = 0;
		gbc_lblLinhas.gridy = 2;
		panel.add(lblLinhas, gbc_lblLinhas);
		
		JButton btnGerar = new JButton("Gerar P\u00E1gina para Impress\u00E3o");
		GridBagConstraints gbc_btnGerar = new GridBagConstraints();
		gbc_btnGerar.gridx = 5;
		gbc_btnGerar.gridy = 3;
		panel.add(btnGerar, gbc_btnGerar);

	}

}
