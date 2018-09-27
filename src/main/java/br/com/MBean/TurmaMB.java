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
	
	public void criarProfessor() {
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
}