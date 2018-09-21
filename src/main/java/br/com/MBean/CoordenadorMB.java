package br.com.MBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.DAO.coordenadorDAO;
import br.com.entities.Coordenador;

@ManagedBean
@ViewScoped
public class CoordenadorMB {
	
	public String nome;
	public Integer nif;
	public String senha;
	public Coordenador c;
	
	
	public void mostrar(){
		coordenadorDAO cDAO = new coordenadorDAO();
		
		cDAO.listarTodos();
		
		
		
		nome = c.getNome();
		nif = c.getLogin();
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNif() {
		return nif;
	}

	public void setNif(Integer nif) {
		this.nif = nif;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Coordenador getC() {
		return c;
	}

	public void setC(Coordenador c) {
		this.c = c;
	}	
}