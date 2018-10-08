package br.com.entities;

public class Aulas {

	private Integer id;
	private Curso curso;
	private Turma turma;
	private Disciplina disciplina;
	private Professor professor;
	private Coordenador coordenador;
	private Integer id_sala;
	
	public Aulas() {
		// TODO Auto-generated constructor stub
	}
	
	public Aulas(Integer id, Curso curso, Turma turma, Disciplina disciplina, Professor professor,
			Coordenador coordenador, Integer id_sala) {
		super();
		this.id = id;
		this.curso = curso;
		this.turma = turma;
		this.disciplina = disciplina;
		this.professor = professor;
		this.coordenador = coordenador;
		this.id_sala = id_sala;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public Integer getId_sala() {
		return id_sala;
	}

	public void setId_sala(Integer id_sala) {
		this.id_sala = id_sala;
	}

}
