package br.com.entities;

public class Salas {

	private Integer id;
	private int numero;

	
	public Salas(Integer id,Integer numero) {
		this.id = id;
		this.numero = numero;
	
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

}
