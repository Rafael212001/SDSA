package br.com.entities;

public class CD {
	
	private int id_colaborador;
	private int id_disciplina;
	
	public CD() {
		// TODO Auto-generated constructor stub
	}
	
	public CD(int id_colaborador, int id_disciplina) {
		super();
		this.id_colaborador = id_colaborador;
		this.id_disciplina = id_disciplina;
	}
	
	public int getId_colaborador() {
		return id_colaborador;
	}
	public void setId_colaborador(int id_colaborador) {
		this.id_colaborador = id_colaborador;
	}
	public int getId_disciplina() {
		return id_disciplina;
	}
	public void setId_disciplina(int id_disciplina) {
		this.id_disciplina = id_disciplina;
	}
}
