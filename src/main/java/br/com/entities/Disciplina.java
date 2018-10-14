package br.com.entities;

public class Disciplina {

	private Integer id;
	private String nome;
	private Integer carga_hora;
	private Integer semestre;
	private Integer id_curso;
	
	public Disciplina() {
		// TODO Auto-generated constructor stub
	}
	
	public Disciplina(Integer id, String nome, Integer carga_hora, Integer semestre,
			Integer id_curso) {
		super();
		this.id = id;
		this.nome = nome;
		this.carga_hora = carga_hora;
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

	public Integer getCarga_hora() {
		return carga_hora;
	}

	public void setCarga_hora(Integer carga_hora) {
		this.carga_hora = carga_hora;
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
}
