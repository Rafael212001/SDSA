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
	Disciplina selc;
	List<Disciplina> discL;
	List<Disciplina> lista;
	disciplinaDAO dDAO = new disciplinaDAO();
	private List<Integer> semestres;
	int ID;

	public DisciplinaMB() {
		listarD();
	}

	public void salvar() {
		if (disc.getId() != null) {
			Disciplina d = dDAO.buscarDisciplina(disc.getId());
			if (d != null && d.getId().equals(disc.getId())) {
				editarDisciplina();
			}
		} else {
			criarDisciplina();
		}
	}

	public void editarDisciplina() {
		if (dDAO.editar(disc)) {
			System.out.println("Disciplina alterada.");
			zerar();
			listarD();
		} else {
			System.out.println("Erro na alteração da disciplina.");
			listarD();
		}
	}

	public void criarDisciplina() {
		disc.setId_curso(ID);
		if (dDAO.inserir(disc)) {
			System.out.println("Disciplina criada.");
			zerar();
			listarD();
		} else {
			System.out.println("Erro na criação da disciplina.");
			listarD();
		}
	}

	private void zerar() {
		disc = new Disciplina();
		dDAO = new disciplinaDAO();
		lista = null;
		selc = null;
	}

	public void editar() {
		disc = selc;
	}

	public void excluir() {
		if (dDAO.excluir(selc.getId())) {
			System.out.println("Disciplina " + selc.getNome() + " excluida.");
		}
	}

	public void listarSemestreC() {
		int i = dDAO.listarId(ID);
		semestres = new ArrayList<Integer>();
		for (int f = 1; f <= i; f++) {
			semestres.add(f);
		}

	}
	
	public String fechar() {
		zerar();
		listarD();
		return "PF('dlg6').hide();";
	}
	
	public void listarD() {
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

	public List<Disciplina> getLista() {
		return lista;
	}

	public void setLista(List<Disciplina> lista) {
		this.lista = lista;
	}

}