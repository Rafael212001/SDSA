package br.com.entities;

public class Carga_horaria_restante {

	private Integer id;
	private int tempo;
	private Integer id_disciplina;
	private Integer id_turma;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public Integer getId_disciplina() {
		return id_disciplina;
	}

	public void setId_disciplina(Integer id_disciplina) {
		this.id_disciplina = id_disciplina;
	}

	public Integer getId_turma() {
		return id_turma;
	}

	public void setId_turma(Integer id_turma) {
		this.id_turma = id_turma;
	}

}
