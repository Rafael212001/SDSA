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
	public int login;
	public String senha;
	List<Coordenador> coo;
	
	public CoordenadorMB() {
		coordenadorDAO cDAO = new coordenadorDAO();
		coo = cDAO.listarTodos();
	}
	
	public void CriarCoordenador() {
		Coordenador c = new Coordenador();
		c.setNome(nome);
		c.setLogin(Integer.valueOf(login));
		c.setSenha(senha);
		
		coordenadorDAO cDAO = new coordenadorDAO();
		if(cDAO.inserir(c)) {
			System.out.println("deu porra");
			listarC();
		}else {
			System.out.println("du não ;-;");
			listarC();
		}
		
	}
	
	private void listarC() {
		coordenadorDAO cDAO = new coordenadorDAO();
		coo = cDAO.listarTodos();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
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