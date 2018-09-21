package br.com.MBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LoginMB {
	
	public String login;
	public String senha;
	
	public String logar() {
		if ((login.equals("batata"))&&(senha.equals("123"))) {
			return "telaCoordenador?faces-redirect=true";
		}
		return login;
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