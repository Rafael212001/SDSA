package br.com.MBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import br.com.DAO.professorDAO;
import br.com.entities.Disciplina;
import br.com.entities.Professor;

@ManagedBean
@ViewScoped
public class ProfessorMB {
	int idC;
	Professor prof;
	List<Professor> profL;
	professorDAO pDAO;
	List<Disciplina> d;

	public ProfessorMB() {
		prof = new Professor();
		pDAO = new professorDAO();
		profL = pDAO.listarTodos();
	}

	public void criarProfessor() {
		if (pDAO.inserir(prof)) {
			System.out.println("deu porra");
			prof = new Professor();
			listarP();
		} else {
			System.out.println("não deu ;-;");
			listarP();
		}
	}

	public void listDisc() {
		d = pDAO.listarId(idC);

	}

	public List<Disciplina> getD() {
		return d;
	}

	public void setD(List<Disciplina> d) {
		this.d = d;
	}

	public int getIdC() {
		return idC;
	}

	public void setIdC(int idC) {
		this.idC = idC;
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