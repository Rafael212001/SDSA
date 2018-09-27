package br.com.MBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.DAO.salaDAO;
import br.com.entities.Salas;

@ManagedBean
@RequestScoped
public class SalasMBean {
	
	Salas sal;
	List<Salas> salL;
	salaDAO sDAO;
	
	public SalasMBean() {
		sal = new Salas();
		sDAO = new salaDAO();
		listarS();
	}
	
	public void criarSala() {
		if(sDAO.inserir(sal)) {
			System.out.println("deu porra");
			sal = new Salas();
			listarS();
		}else {
			System.out.println("não deu ;-;");
			listarS();
		}
	}
	
	private void listarS() {
		salL = sDAO.listarTodos();
	}

	public Salas getSal() {
		return sal;
	}

	public void setSal(Salas sal) {
		this.sal = sal;
	}

	public List<Salas> getSalL() {
		return salL;
	}

	public void setSalL(List<Salas> salL) {
		this.salL = salL;
	}

	public salaDAO getsDAO() {
		return sDAO;
	}

	public void setsDAO(salaDAO sDAO) {
		this.sDAO = sDAO;
	}
}
