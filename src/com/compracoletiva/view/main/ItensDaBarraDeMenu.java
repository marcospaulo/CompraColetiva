package com.compracoletiva.view.main;

public enum ItensDaBarraDeMenu {

	OFERTA_DO_DIA("Oferta do dia"), OFERTAS_ANTERIORES("Ofertas anteriores");

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
