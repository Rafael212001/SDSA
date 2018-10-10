package br.com.MBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import br.com.DAO.disciplinaDAO;
import br.com.entities.Disciplina;

@ManagedBean
@ViewScoped
public class DisciplinaMB {
	Disciplina disc = new Disciplina();
	List<Disciplina> discL;
	disciplinaDAO dDAO = new disciplinaDAO();
	List<Integer> semestres;
	int ID;

	public DisciplinaMB() {

	}

	public void criarDisciplina() {
		if (dDAO.inserir(disc)) {
			System.out.println("deu porra");
			disc = new Disciplina();
			listarD();
		} else {
			System.out.println("não deu ;-;");
			listarD();
		}
	}

	public void listarSemestreC(int id) {
		ID = id;
		int i = dDAO.listarId(id);
		semestres = new ArrayList<Integer>();
		for (int f = 1; f <= i; f++) {
			semestres.add(f);
		}
	}

	private void listarD() {
		discL = dDAO.listarTodos(ID);
	}

	public Disciplina getDisc() {
		return disc;
	}

	public void setDisc(Disciplina disc) {
		this.disc = disc;
	}

	public List<Disciplina> getDiscL() {
		return discL;
	}

	public void setDiscL(List<Disciplina> discL) {
		this.discL = discL;
	}

	public disciplinaDAO getdDAO() {
		return dDAO;
	}

	public void setdDAO(disciplinaDAO dDAO) {
		this.dDAO = dDAO;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public List<Integer> getSemestres() {
		return semestres;
	}

	public void setSemestres(List<Integer> semestres) {
		this.semestres = semestres;
	}

}