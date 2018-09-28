package br.com.MBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.DAO.turmaDAO;
import br.com.entities.Turma;

@ManagedBean
@RequestScoped
public class TurmaMB {
	Turma tur;
	List<Turma> turL;
	turmaDAO tDAO;
	
	public TurmaMB() {
		tur = new Turma();
		tDAO = new turmaDAO();
	}
	
	public void criarTurma() {
		if(tDAO.inserir(tur)) {
			System.out.println("deu porra");
			tur = new Turma();
			listarT();
		}else {
			System.out.println("não deu ;-;");
			listarT();
		}
	}
	
	private void listarT() {
		turL = tDAO.listarTodos();
	}

	public Turma getTur() {
		return tur;
	}

	public void setTur(Turma tur) {
		this.tur = tur;
	}

	public List<Turma> getTurL() {
		return turL;
	}

	public void setTurL(List<Turma> turL) {
		this.turL = turL;
	}

	public turmaDAO gettDAO() {
		return tDAO;
	}

	public void settDAO(turmaDAO tDAO) {
		this.tDAO = tDAO;
	}
	
	
}