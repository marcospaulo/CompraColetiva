package com.compracoletiva.server.entities;

import java.io.Serializable;

public class InformacoesContato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6258871488477032317L;

	private String nome = "";
	private String email = "";

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
