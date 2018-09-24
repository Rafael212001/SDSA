package br.com.MBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.DAO.coordenadorDAO;
import br.com.entities.Coordenador;

@ManagedBean
@RequestScoped
public class CoordenadorMB {
	Coordenador coor;
	List<Coordenador> coo;
	coordenadorDAO cDAO;

	public CoordenadorMB() {
		coor = new Coordenador();
		cDAO = new coordenadorDAO();
		coo = cDAO.listarTodos();
		System.out.println("bAISI");
	}

	public void criarCoordenador(ActionEvent event) {
		System.out.println("ta entrando sa merda");
		if (cDAO.inserir(coor)) {
			System.out.println("deu porra");
			coor = new Coordenador();
			listarC();
		} else {
			System.out.println("du não ;-;");
			listarC();
		}
	}
	
	public void excluirCoordenador() {
		
		
//		if(cDAO.excluir(id)) {
//			dlCoor();
//		}else {
//			errorCoor();
//		}
	}

	private void listarC() {
		coo = cDAO.listarTodos();
	}
	
	public void dlCoor() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado", "Coordenador foi deletado com sucesso."));
    }
	
	public void errorCoor() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Coordenador não pode ser deletado."));
    }

	public Coordenador getCoor() {
		return coor;
	}

	public void setCoor(Coordenador coor) {
		this.coor = coor;
	}

	public List<Coordenador> getCoo() {
		return coo;
	}

	public void setCoo(List<Coordenador> coo) {
		this.coo = coo;
	}
	
}