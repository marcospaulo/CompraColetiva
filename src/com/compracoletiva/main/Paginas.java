package com.compracoletiva.main;

public enum Paginas {

	PRINCIPAL("main");

	private String nome;

	private Paginas(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
