package br.com.entities;

public class Turma {

	private Integer id;
	private String nome;
	private Integer periodo;
	private Integer semestre;
	private Integer id_curso;
	private Curso curso;
	
	
	public Turma() {
		// TODO Auto-generated constructor stub
	}
	
	public Turma(Integer id, String nome, Integer periodo, Integer semestre,
			Integer id_curso) {
		super();
		this.id = id;
		this.nome = nome;
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

	public Integer getPeriodo() {
		return periodo;
	}
	
	public String getFormatPeriodo() {
		if(periodo == 1) {
			return "Manha";
		}else if(periodo == 2) {
			return "Tarde";
		}else {
			return "Noite";
		}
	}
	
	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Integer getId_curso() {
		return id_curso;
	}

	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
