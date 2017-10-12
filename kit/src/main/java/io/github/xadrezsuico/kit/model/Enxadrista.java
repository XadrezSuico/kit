package io.github.xadrezsuico.kit.model;

import io.github.xadrezsuico.kit.exceptions.EnxadristaException;

public class Enxadrista {
	private int id;
	private String nome;
	private String sobrenome;
	
	private boolean isNew;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	
	public boolean camposOk() throws EnxadristaException{
		if((nome != null || nome != "") && (sobrenome != null || sobrenome != "") && (id != 0 || isNew)){
			return true;
		}

		if(nome == null || nome == "")
			throw new EnxadristaException("O nome do enxadrista é obrigatório!");
		
		if(sobrenome == null || sobrenome == "")
			throw new EnxadristaException("O sobrenome do enxadrista é obrigatório!");
		
		if(id != 0 && !isNew)
			throw new EnxadristaException("O código do enxadrista é obrigatório para alteração do cadastro!");
		
		throw new EnxadristaException("Alguma coisa não esperada aconteceu!");
	}
}
