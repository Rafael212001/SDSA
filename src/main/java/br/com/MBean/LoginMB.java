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
	private boolean logado = false;

	public String logar() {
		cDAO = new coordenadorDAO();
		c = cDAO.buscaCoordenador(login);

		if (c != null && c.getSenha().equals(senha)) {
			logado = true;
			return "telaCoordenador?faces-redirect=true";
		}
		return null;
	}
	
	public String sair() {
		logado = false;
		return "telaLogin?faces-redirect=true";
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

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	
}