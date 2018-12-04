package br.com.entities;

public class Salas {

	private Integer numero;
	private int contador;
	
	public Salas() {
		// TODO Auto-generated constructor stub
	}
	
	public Salas(Integer numero, int contador) {
		super();
		this.numero = numero;
		this.contador = contador;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	
}
