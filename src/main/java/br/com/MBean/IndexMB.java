package br.com.MBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class IndexMB {
	
	public String troca() {
		return "telaLogin?faces-redirect=true";
	}
	
}