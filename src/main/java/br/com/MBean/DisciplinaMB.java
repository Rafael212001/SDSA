package br.com.MBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.com.DAO.disciplinaDAO;
import br.com.entities.Disciplina;

@ManagedBean
@ViewScoped
public class DisciplinaMB {
	Disciplina disc = new Disciplina();
	Disciplina selc = new Disciplina();
	List<Disciplina> discL;
	disciplinaDAO dDAO = new disciplinaDAO();
	private List<Integer> semestres;
	int ID;

	public DisciplinaMB() {
		listarD();
	}

	public void criarDisciplina() {
		disc.setId_curso(ID);
		if (dDAO.inserir(disc)) {
			System.out.println("deu porra");
			zerar();
			listarD();
		} else {
			System.out.println("não deu ;-;");
			listarD();
		}
	}

	private void zerar() {
		disc = new Disciplina();
		dDAO = new disciplinaDAO();
	}

	public void listarSemestreC() {
		int i = dDAO.listarId(ID);
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

	public Disciplina getSelc() {
		return selc;
	}

	public void setSelc(Disciplina selc) {
		this.selc = selc;
	}

}