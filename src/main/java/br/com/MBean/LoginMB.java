package br.com.MBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.DAO.coordenadorDAO;
import br.com.entities.Coordenador;

@ManagedBean
@ViewScoped
public class LoginMB {
	
	public String login;
	public String senha;
	
	public String logar() {
		
		coordenadorDAO cDAO = new coordenadorDAO();
		Coordenador c = cDAO.buscaCoordenador(login);
		
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
	
}