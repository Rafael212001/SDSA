package br.com.entities;

public class Salas {

	private String descricao;
	private Integer numero;
	
	public Salas() {
		// TODO Auto-generated constructor stub
	}
	
	public Salas(String descricao, Integer numero) {
		super();
		this.descricao = descricao;
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
