package br.com.MBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.DAO.coordenadorDAO;
import br.com.entities.Coordenador;

@ManagedBean
@SessionScoped
public class LoginMB {

	public String login;
	public String senha;
	coordenadorDAO cDAO;
	Coordenador c;

	public String logar() {

		cDAO = new coordenadorDAO();
		c = cDAO.buscaCoordenador(login);

		if (c != null && c.getSenha().equals(senha)) {
			return "telaCoordenador?faces-redirect=true";
		}
		return null;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public coordenadorDAO getcDAO() {
		return cDAO;
	}

	public void setcDAO(coordenadorDAO cDAO) {
		this.cDAO = cDAO;
	}

	public Coordenador getC() {
		return c;
	}

	public void setC(Coordenador c) {
		this.c = c;
	}
	
}