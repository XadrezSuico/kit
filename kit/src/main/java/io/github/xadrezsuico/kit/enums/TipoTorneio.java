package io.github.xadrezsuico.kit.enums;

public enum TipoTorneio {
	INDIVIDUAL(1,"INDIVIDUAL"),
	EQUIPE(2,"EQUIPE");
	
	private int id;
	private String tipo;
	
	TipoTorneio(int id, String tipo){
		this.id = id;
		this.tipo = tipo;
	}
	
	public int getId(){
		return this.id;
	}
	public String getTipo(){
		return this.tipo;
	}
}
