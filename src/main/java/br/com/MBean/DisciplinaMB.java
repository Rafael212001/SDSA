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
	Disciplina disc;
	List<Disciplina> discL;
	disciplinaDAO dDAO;
	int Id;
	List<Integer> semestres;

	public DisciplinaMB() {
		disc = new Disciplina();
		dDAO = new disciplinaDAO();
		listarSemestreC();
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

	public void listarSemestreC() {
		int i = dDAO.listarId(Id);
		semestres = new ArrayList<Integer>();
		for (int f = 1; f <= i; f++) {
			semestres.add(f);
		}
	}

	private void listarD() {

		discL = dDAO.listarTodos(Id);
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

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public List<Integer> getSemestres() {
		return semestres;
	}

	public void setSemestres(List<Integer> semestres) {
		this.semestres = semestres;
	}

}