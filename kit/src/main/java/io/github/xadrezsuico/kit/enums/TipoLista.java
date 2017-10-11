package io.github.xadrezsuico.kit.enums;

public enum TipoLista {
	LISTA_INDIVIDUAL(1,"LISTA INDIVIDUAL NÃO PRÉ-PREENCHIDA"),
	LISTA_INDIVIDUAL_PREENCHIDA(2,"LISTA INDIVIDUAL PRÉ-PREENCHIDA"),
	LISTA_EQUIPE(3,"LISTA POR EQUIPES NÃO PRÉ-PREENCHIDA"),
	LISTA_EQUIPE_PREENCHIDA(4,"LISTA POR EQUIPES PRÉ-PREENCHIDA");
	
	private int id;
	private String tipo;
	
	TipoLista(int id, String tipo){
		this.id = id;
		this.tipo = tipo;
	}
	
	public int getId(){
		return this.id;
	}
	public String getTipo(){
		return this.tipo;
	}
	
	public String toString(){
		return this.tipo;
	}

}
