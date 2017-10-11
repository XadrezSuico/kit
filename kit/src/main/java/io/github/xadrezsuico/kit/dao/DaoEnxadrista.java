package io.github.xadrezsuico.kit.dao;

import java.util.Map;

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
	public Map<Integer, Enxadrista> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
