package br.com.entities;

public class Aulas {

	private Integer id;
	private Curso curso;
	private Integer id_turmas;
	private Integer id_disciplina;
	private Integer id_colaborador;
	private Integer id_coordenador;
	private Integer id_sala;
	
	

	public Aulas(Integer id, Curso curso, Integer id_turmas, Integer id_disciplina, Integer id_colaborador,
			Integer id_coordenador, Integer id_sala) {
		super();
		this.id = id;
		this.curso = curso;
		this.id_turmas = id_turmas;
		this.id_disciplina = id_disciplina;
		this.id_colaborador = id_colaborador;
		this.id_coordenador = id_coordenador;
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

	public Integer getId_turmas() {
		return id_turmas;
	}

	public void setId_turmas(Integer id_turmas) {
		this.id_turmas = id_turmas;
	}

	public Integer getId_disciplina() {
		return id_disciplina;
	}

	public void setId_disciplina(Integer id_disciplina) {
		this.id_disciplina = id_disciplina;
	}

	public Integer getId_colaborador() {
		return id_colaborador;
	}

	public void setId_colaborador(Integer id_colaborador) {
		this.id_colaborador = id_colaborador;
	}

	public Integer getId_coordenador() {
		return id_coordenador;
	}

	public void setId_coordenador(Integer id_coordenador) {
		this.id_coordenador = id_coordenador;
	}

	public Integer getId_sala() {
		return id_sala;
	}

	public void setId_sala(Integer id_sala) {
		this.id_sala = id_sala;
	}
	
	
	

}
