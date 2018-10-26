package br.com.entities;

public class CD {

	private int id;
	private Integer id_colaborador;
	private Integer id_disciplina;

	public CD() {
		// TODO Auto-generated constructor stub
	}

	public CD(int id, Integer id_colaborador, Integer id_disciplina) {
		super();
		this.id = id;
		this.id_colaborador = id_colaborador;
		this.id_disciplina = id_disciplina;
	}

	public Integer getId_colaborador() {
		return id_colaborador;
	}

	public void setId_colaborador(Integer id_colaborador) {
		this.id_colaborador = id_colaborador;
	}

	public Integer getId_disciplina() {
		return id_disciplina;
	}

	public void setId_disciplina(Integer id_disciplina) {
		this.id_disciplina = id_disciplina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
