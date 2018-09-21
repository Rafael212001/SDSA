package br.com.MBean;

import java.text.ParseException;
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
	List<Coordenador> coo;
	coordenadorDAO cDAO;
	Coordenador c;
	
	
	public CoordenadorMB() throws ParseException{
		cDAO = new coordenadorDAO();
		coo = cDAO.listarTodos();
	}
	
	public void CriarCoordenador() {
		
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

	public List<Coordenador> getCoo() {
		return coo;
	}

	public void setCoo(List<Coordenador> coo) {
		this.coo = coo;
	}
}