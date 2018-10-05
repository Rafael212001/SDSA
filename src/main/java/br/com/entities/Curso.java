package br.com.entities;

public class Curso {

	private Integer id;
	private String nome;
	private Integer qtd_semestre;
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	
	public Curso(Integer id, String nome, Integer qtd_semestre) {
		super();
		this.id = id;
		this.nome = nome;
		this.qtd_semestre = qtd_semestre;
	}

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

	public Integer getQtd_semestre() {
		return qtd_semestre;
	}

	public void setQtd_semestre(Integer qtd_semestre) {
		this.qtd_semestre = qtd_semestre;
	}

}
