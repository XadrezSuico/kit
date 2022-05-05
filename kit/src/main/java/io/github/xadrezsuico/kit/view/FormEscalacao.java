package io.github.xadrezsuico.kit.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import io.github.xadrezsuico.kit.dao.DaoEnxadrista;
import io.github.xadrezsuico.kit.dao.DaoEquipe;
import io.github.xadrezsuico.kit.data.EnxadristaDataSource;
import io.github.xadrezsuico.kit.data.EquipeDataSource;
import io.github.xadrezsuico.kit.enums.TipoLista;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JButton;

public class FormEscalacao extends JPanel {

	private DefaultView defaultView;
	private JTextField tf_linhas;
	/**
	 * Create the panel.
	 */
	public FormEscalacao(DefaultView defaultView) {
		
		this.defaultView = defaultView;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblAquiVocPode = new JLabel("Aqui voc\u00EA poder\u00E1 gerar um relat\u00F3rio com a quantidade de escala\u00E7\u00F5es que necessitar.");
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
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblQuantidadeDeLinhas = new JLabel("Quantidade de Linhas:");
		GridBagConstraints gbc_lblQuantidadeDeLinhas = new GridBagConstraints();
		gbc_lblQuantidadeDeLinhas.anchor = GridBagConstraints.EAST;
		gbc_lblQuantidadeDeLinhas.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidadeDeLinhas.gridx = 0;
		gbc_lblQuantidadeDeLinhas.gridy = 0;
		panel.add(lblQuantidadeDeLinhas, gbc_lblQuantidadeDeLinhas);
		
		tf_linhas = new JTextField();
		GridBagConstraints gbc_tf_linhas = new GridBagConstraints();
		gbc_tf_linhas.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_linhas.gridwidth = 5;
		gbc_tf_linhas.insets = new Insets(0, 0, 5, 0);
		gbc_tf_linhas.anchor = GridBagConstraints.NORTH;
		gbc_tf_linhas.gridx = 1;
		gbc_tf_linhas.gridy = 0;
		panel.add(tf_linhas, gbc_tf_linhas);
		tf_linhas.setColumns(10);
		
		JButton btnGerar = new JButton("Gerar P\u00E1gina para Impress\u00E3o");
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gerarRelatorio();
			}
		});
		GridBagConstraints gbc_btnGerar = new GridBagConstraints();
		gbc_btnGerar.gridx = 5;
		gbc_btnGerar.gridy = 1;
		panel.add(btnGerar, gbc_btnGerar);
	}
	
	protected void gerarRelatorio() {
		final FormEscalacao formEscalacao = FormEscalacao.this;
		final LoadingView loadingView = new LoadingView();
		loadingView.setVisible(true);
		
		Thread threadPagina = new Thread(new Runnable(){
	        JasperPrint print = null;
	        InputStream arquivo = null;
			Map<String, Object> chaves = new HashMap<String, Object>();
			@Override
			public void run() {
				// TODO Auto-generated method stub

				chaves.put("nome", defaultView.getMain().getSoftwareProperties().getProperty("nome"));
				
				try {
					if(tf_linhas.getText() == null){
						JOptionPane.showMessageDialog(formEscalacao, "O número de linhas é necessário para essa lista.");
					}
					
					arquivo = getClass().getResourceAsStream("/io/github/xadrezsuico/kit/report/escalacao.jasper");
					print = JasperFillManager.fillReport(arquivo, chaves, new JREmptyDataSource(Integer.valueOf(tf_linhas.getText())));
					
					
			        JasperViewer viewer = new JasperViewer(print, false);
			        viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
			        viewer.setTitle("LISTA DE PRESENÇA");
			        viewer.setVisible(true);
			        loadingView.setVisible(false);
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			        loadingView.setVisible(false);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(formEscalacao, "O campo de QUANTIDADE DE LINHAS é obrigatório o preenchimento com um número.");
			        loadingView.setVisible(false);
				}
			}
			
		});
		threadPagina.start();
	}

}
