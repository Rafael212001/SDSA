package br.com.entities;

public class Professor {
	private int id;
	private String nome;
	private String disciplina_le;
	private int carga_hora;
	private int restante;
	private int tipo;
	private int foto;
	private int id_disciplina;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDisciplina_le() {
		return disciplina_le;
	}
	public void setDisciplina_le(String disciplina_le) {
		this.disciplina_le = disciplina_le;
	}
	public int getCarga_hora() {
		return carga_hora;
	}
	public void setCarga_hora(int carga_hora) {
		this.carga_hora = carga_hora;
	}
	public int getRestante() {
		return restante;
	}
	public void setRestante(int restante) {
		this.restante = restante;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getFoto() {
		return foto;
	}
	public void setFoto(int foto) {
		this.foto = foto;
	}
	public int getId_disciplina() {
		return id_disciplina;
	}
	public void setId_disciplina(int id_disciplina) {
		this.id_disciplina = id_disciplina;
	}
	
	
}
