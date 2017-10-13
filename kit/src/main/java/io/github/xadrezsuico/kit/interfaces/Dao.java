package io.github.xadrezsuico.kit.interfaces;

import java.util.Map;
import java.util.List;

public interface Dao<T, K> {
	public void insert(T t);
	public void update(T t, K k);
	public void delete(K k);
	public T search(K k);
	public Map<K,T> search(String field, String text);
	public Map<K,T> mapAll();
	public List<T> listAll();
}
