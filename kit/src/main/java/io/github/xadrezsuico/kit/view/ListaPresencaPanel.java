package io.github.xadrezsuico.kit.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
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
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class ListaPresencaPanel extends JPanel {
	private JTextField tf_linhas;
	private JComboBox cb_tipo;
	private DefaultView defaultView;

	/**
	 * Create the panel.
	 */
	public ListaPresencaPanel(DefaultView defaultView) {
		this.defaultView = defaultView;
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
		
		cb_tipo = new JComboBox(TipoLista.values());
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
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gerarRelatorio();
			}
		});
		GridBagConstraints gbc_btnGerar = new GridBagConstraints();
		gbc_btnGerar.gridx = 5;
		gbc_btnGerar.gridy = 3;
		panel.add(btnGerar, gbc_btnGerar);

	}

	protected void gerarRelatorio() {
		final ListaPresencaPanel listaPresencaPanel = ListaPresencaPanel.this;
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
					switch(((TipoLista) cb_tipo.getSelectedItem()).getId()){
						case 1:
							if(tf_linhas.getText() == null){
								JOptionPane.showMessageDialog(listaPresencaPanel, "O n�mero de linhas � necess�rio para essa lista.");
							}
							arquivo = getClass().getResourceAsStream("/io/github/xadrezsuico/kit/report/lista_presenca_individual_nao.jasper");
							print = JasperFillManager.fillReport(arquivo, chaves, new JREmptyDataSource(Integer.valueOf(tf_linhas.getText())));
							break;
						case 2:
							DaoEnxadrista daoEnxadrista = new DaoEnxadrista();
							arquivo = getClass().getResourceAsStream("/io/github/xadrezsuico/kit/report/lista_presenca_individual_sim.jasper");
							print = JasperFillManager.fillReport(arquivo, chaves, new EnxadristaDataSource(daoEnxadrista.listAll()));
							break;
						case 3:
							if(tf_linhas.getText() == null){
								JOptionPane.showMessageDialog(listaPresencaPanel, "O n�mero de linhas � necess�rio para essa lista.");
							}
							arquivo = getClass().getResourceAsStream("/io/github/xadrezsuico/kit/report/lista_presenca_equipe_nao.jasper");
							print = JasperFillManager.fillReport(arquivo, chaves, new JREmptyDataSource(Integer.valueOf(tf_linhas.getText())));
							break;
						case 4:
							DaoEquipe daoEquipe = new DaoEquipe();
							arquivo = getClass().getResourceAsStream("/io/github/xadrezsuico/kit/report/lista_presenca_equipe_sim.jasper");
							print = JasperFillManager.fillReport(arquivo, chaves, new EquipeDataSource(daoEquipe.listAll()));
							break;
					}
			        JasperViewer viewer = new JasperViewer(print, false);
			        viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
			        viewer.setTitle("LISTA DE PRESEN�A");
			        viewer.setVisible(true);
			        loadingView.setVisible(false);
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			        loadingView.setVisible(false);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(listaPresencaPanel, "O campo de QUANTIDADE DE LINHAS � obrigat�rio o preenchimento com um n�mero.");
			        loadingView.setVisible(false);
				}
			}
			
		});
		threadPagina.start();
	}
	
	

}
