package br.com.MBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.DAO.professorDAO;
import br.com.entities.Professor;

@ManagedBean
@ViewScoped
public class IndexMB {

	professorDAO pDAO = new professorDAO();
	List<Professor> profL;
	int idColaborador;

	public IndexMB() {
		listarP();
	}

	public void listarP() {
		profL = pDAO.listarTodos();
	}

	public String troca() {
		return "telaLogin?faces-redirect=true";
	}

	public professorDAO getpDAO() {
		return pDAO;
	}

	public void setpDAO(professorDAO pDAO) {
		this.pDAO = pDAO;
	}

	public int getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}

	public List<Professor> getProfL() {
		return profL;
	}

	public void setProfL(List<Professor> profL) {
		this.profL = profL;
	}

}