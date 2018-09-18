package br.com.entities;

public class Salas {

	private Integer id;
	private int numero;
	private Integer id_sala;
	
	public Salas(Integer id,Integer numero,Integer id_sala) {
		this.id = id;
		this.numero = numero;
		this.id_sala = id_sala;	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Integer getId_aula() {
		return id_sala;
	}

	public void setId_aula(Integer id_aula) {
		this.id_sala = id_aula;
	}

}
