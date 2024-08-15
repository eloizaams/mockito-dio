package com.eloizaams.mockito_examples;

import java.time.LocalDate;

public class Pessoa {
	
	private String name;
	private String documento;
	private LocalDate nascimento;
	private DadosLocalizacao endereco;

	public Pessoa(String name, String documento, LocalDate nascimento) {
		this.name = name;
		this.documento = documento;
		this.nascimento = nascimento;
	}

	public String getName() {
		return name;
	}

	public String getDocumento() {
		return documento;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public DadosLocalizacao getEndereco() {
		return endereco;
	}

	public void setEndereco(DadosLocalizacao endereco) {
		this.endereco = endereco;
	}


	
	

}
