package com.compracoletiva.view.main;

public enum ItensDaBarraDeMenu {

	OFERTA_DO_DIA("Grande Lance do Dia"), OFERTAS_ANTERIORES("Grande Lances Anteriores");

	private String nome;

	private ItensDaBarraDeMenu(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
