package io.github.xadrezsuico.kit.model;

public class RodadaEquipe {
	private int id;
	private Equipe equipe_w;
	private Equipe equipe_b;
	private Rodada rodada;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Equipe getEquipe_w() {
		return equipe_w;
	}

	public void setEquipe_w(Equipe equipe_w) {
		this.equipe_w = equipe_w;
	}

	public Equipe getEquipe_b() {
		return equipe_b;
	}

	public void setEquipe_b(Equipe equipe_b) {
		this.equipe_b = equipe_b;
	}

	public Rodada getRodada() {
		return rodada;
	}

	public void setRodada(Rodada rodada) {
		this.rodada = rodada;
	}

}
