package br.com.entities;

public class Salas {

	private Integer id;
	private String descricao;
	private Integer numero;
	
	public Salas() {
		// TODO Auto-generated constructor stub
	}
	
	public Salas(Integer id, String descricao, Integer numero) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
