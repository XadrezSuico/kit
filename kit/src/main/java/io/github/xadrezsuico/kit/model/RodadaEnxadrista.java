package io.github.xadrezsuico.kit.model;

public class RodadaEnxadrista {
	private int id;
	private Enxadrista enxadrista_w;
	private Enxadrista enxadrista_b;
	private Rodada rodada;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Enxadrista getEnxadrista_w() {
		return enxadrista_w;
	}

	public void setEnxadrista_w(Enxadrista enxadrista_w) {
		this.enxadrista_w = enxadrista_w;
	}

	public Enxadrista getEnxadrista_b() {
		return enxadrista_b;
	}

	public void setEnxadrista_b(Enxadrista enxadrista_b) {
		this.enxadrista_b = enxadrista_b;
	}

	public Rodada getRodada() {
		return rodada;
	}

	public void setRodada(Rodada rodada) {
		this.rodada = rodada;
	}
	
}
