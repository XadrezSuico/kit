package io.github.xadrezsuico.kit.data;

import java.util.List;

import io.github.xadrezsuico.kit.model.Equipe;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRRewindableDataSource;

public class EquipeDataSource implements JRRewindableDataSource {

	private int index;
	
	private List<Equipe> lista;
	
	public EquipeDataSource(List<Equipe> lista){
		this.index = 0;
		this.lista = lista;
	}
	
	@Override
	public boolean next() throws JRException {
		// TODO Auto-generated method stub
		return (index++ < lista.size());
	}

	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		// TODO Auto-generated method stub
		switch(jrField.getName()){
			case "id":
				return lista.get(index).getId();
			case "nome":
				return lista.get(index).getNome();
		}
		return null;
	}

	@Override
	public void moveFirst() throws JRException {
		// TODO Auto-generated method stub
		this.index = 0;
	}

}
