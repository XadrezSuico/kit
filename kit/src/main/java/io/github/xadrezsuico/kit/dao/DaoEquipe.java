package io.github.xadrezsuico.kit.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.github.xadrezsuico.kit.interfaces.Dao;
import io.github.xadrezsuico.kit.model.Equipe;

public class DaoEquipe implements Dao<Equipe, Integer> {

	@Override
	public void insert(Equipe t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Equipe t, Integer k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Equipe search(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Equipe> search(String field, String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Equipe> mapAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipe> listAll() {
		List<Equipe> lista = new ArrayList<Equipe>();
		return lista;
	}

}
