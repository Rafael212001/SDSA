package br.com.entities;

public class Turma {

	private Integer id;
	private String nome;
	private int qtd_alunos;
	private int divisao;
	private int periodo;
	private int semestre;
	private int id_curso;
	
	public Turma(Integer id, String nome, Integer qtd_alunos, Integer divisao, Integer periodo, Integer semestre, Integer id_curso) {
		this.id = id;
		this.nome = nome;
		this.qtd_alunos = qtd_alunos;
		this.divisao = divisao;
		this.periodo = periodo;
		this.semestre = semestre;
		this.id_curso = id_curso;
		
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

	public int getQtd_alunos() {
		return qtd_alunos;
	}

	public void setQtd_alunos(int qtd_alunos) {
		this.qtd_alunos = qtd_alunos;
	}

	public int getDivisao() {
		return divisao;
	}

	public void setDivisao(int divisao) {
		this.divisao = divisao;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

}
