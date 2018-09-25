package br.com.MBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.DAO.professorDAO;
import br.com.entities.Professor;

@ManagedBean
@RequestScoped
public class ProfessorMB {
	Professor prof;
	List<Professor> profL;
	professorDAO pDAO;
	
	public ProfessorMB() {
		prof = new Professor();
		pDAO = new professorDAO();
		profL = pDAO.listarTodos();
	}
	
	public void criarProfessor() {
		if(pDAO.inserir(prof)) {
			System.out.println("deu porra");
			prof = new Professor();
			listarP();
		}else {
			System.out.println("não deu ;-;");
			listarP();
		}
	}
	
	private void listarP() {
		profL = pDAO.listarTodos();
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public List<Professor> getProfL() {
		return profL;
	}

	public void setProfL(List<Professor> profL) {
		this.profL = profL;
	}

	public professorDAO getpDAO() {
		return pDAO;
	}

	public void setpDAO(professorDAO pDAO) {
		this.pDAO = pDAO;
	}
}