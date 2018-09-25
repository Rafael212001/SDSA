package br.com.entities;

public class Curso {

	private Integer id;
	private String nome;
	private int qtd_semestre;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtd_semestre() {
		return qtd_semestre;
	}

	public void setQtd_semestre(int qtd_semestre) {
		this.qtd_semestre = qtd_semestre;
	}

}
