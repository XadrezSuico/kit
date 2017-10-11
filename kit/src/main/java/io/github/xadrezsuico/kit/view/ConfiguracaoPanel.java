package io.github.xadrezsuico.kit.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import io.github.xadrezsuico.kit.enums.TipoTorneio;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfiguracaoPanel extends JPanel {
	private JTextField tf_nomeTorneio;
	private JComboBox cb_tipo;

	private DefaultView defaultView;
	/**
	 * Create the panel.
	 */
	public ConfiguracaoPanel(DefaultView defaultView) {
		this.defaultView = defaultView;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblAquiVocPode = new JLabel("Aqui voc\u00EA pode definir nome do torneio, logos e mais.");
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
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNomeDoTorneio = new JLabel("Nome do Torneio:");
		GridBagConstraints gbc_lblNomeDoTorneio = new GridBagConstraints();
		gbc_lblNomeDoTorneio.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeDoTorneio.anchor = GridBagConstraints.EAST;
		gbc_lblNomeDoTorneio.gridx = 0;
		gbc_lblNomeDoTorneio.gridy = 0;
		panel.add(lblNomeDoTorneio, gbc_lblNomeDoTorneio);
		
		tf_nomeTorneio = new JTextField();
		GridBagConstraints gbc_tf_nomeTorneio = new GridBagConstraints();
		gbc_tf_nomeTorneio.gridwidth = 7;
		gbc_tf_nomeTorneio.insets = new Insets(0, 0, 5, 5);
		gbc_tf_nomeTorneio.fill = GridBagConstraints.BOTH;
		gbc_tf_nomeTorneio.gridx = 1;
		gbc_tf_nomeTorneio.gridy = 0;
		panel.add(tf_nomeTorneio, gbc_tf_nomeTorneio);
		tf_nomeTorneio.setColumns(10);
		
		JLabel lblTipoDeTorneio = new JLabel("Tipo de Torneio:");
		GridBagConstraints gbc_lblTipoDeTorneio = new GridBagConstraints();
		gbc_lblTipoDeTorneio.anchor = GridBagConstraints.EAST;
		gbc_lblTipoDeTorneio.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeTorneio.gridx = 0;
		gbc_lblTipoDeTorneio.gridy = 1;
		panel.add(lblTipoDeTorneio, gbc_lblTipoDeTorneio);
		
		cb_tipo = new JComboBox(TipoTorneio.values());
		GridBagConstraints gbc_cb_tipo = new GridBagConstraints();
		gbc_cb_tipo.gridwidth = 7;
		gbc_cb_tipo.insets = new Insets(0, 0, 5, 5);
		gbc_cb_tipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_tipo.gridx = 1;
		gbc_cb_tipo.gridy = 1;
		panel.add(cb_tipo, gbc_cb_tipo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.gridx = 7;
		gbc_btnSalvar.gridy = 2;
		panel.add(btnSalvar, gbc_btnSalvar);
		
		tf_nomeTorneio.setText(defaultView.getMain().getSoftwareProperties().getProperty("nome"));
		cb_tipo.setSelectedItem(TipoTorneio.values()[Integer.valueOf(defaultView.getMain().getSoftwareProperties().getProperty("tipo"))-1]);
	}
	protected void salvar() {
		defaultView.getMain().getSoftwareProperties().setProperty("nome", tf_nomeTorneio.getText());
		defaultView.getMain().getSoftwareProperties().setProperty("tipo", String.valueOf(((TipoTorneio) cb_tipo.getSelectedItem()).getId()));
		JOptionPane.showMessageDialog(defaultView, "CONFIGURAÇÕES SALVAS COM SUCESSO!");
	}

}
