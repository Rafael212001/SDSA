package br.com.entities;

public class Disciplina {

	private Integer id;
	private String nome;
	private int carga_hora;
	private int id_turma;
	private int id_curso;
	
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
	public int getCarga_hora() {
		return carga_hora;
	}
	public void setCarga_hora(int carga_hora) {
		this.carga_hora = carga_hora;
	}
	public int getId_turma() {
		return id_turma;
	}
	public void setId_turma(int id_turma) {
		this.id_turma = id_turma;
	}
	public int getId_curso() {
		return id_curso;
	}
	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}
}
