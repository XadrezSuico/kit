package io.github.xadrezsuico.kit.dao;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import io.github.xadrezsuico.kit.interfaces.Dao;
import io.github.xadrezsuico.kit.model.Enxadrista;

public class DaoEnxadrista implements Dao<Enxadrista, Integer> {

	@Override
	public void insert(Enxadrista t) {
		t.camposOk();
		
	}

	@Override
	public void update(Enxadrista t, Integer k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Enxadrista search(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Enxadrista> search(String field, String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Enxadrista> mapAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enxadrista> listAll() {
		// TODO Auto-generated method stub
		List<Enxadrista> lista = new ArrayList<Enxadrista>();
		return lista;
	}

}
