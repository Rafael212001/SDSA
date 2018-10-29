package br.com.MBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.DAO.coordenadorDAO;
import br.com.entities.Coordenador;

@ManagedBean
@ViewScoped
public class CoordenadorMB {
	Coordenador coor = new Coordenador();
	coordenadorDAO cDAO = new coordenadorDAO();
	List<Coordenador> coo;
	Coordenador selc;

	public CoordenadorMB() {
		listarC();
	}

	public void criarCoordenador(ActionEvent event) {
		System.out.println("ta entrando sa merda");
		if (cDAO.inserir(coor)) {
			System.out.println("deu porra");
			zerar();
			listarC();
		} else {
			System.out.println("deu não ;-;");
			listarC();
		}
	}

	private void zerar() {
		coor = new Coordenador();
		selc = new Coordenador();
		cDAO = new coordenadorDAO();
	}

	public void listarId() {
		int i = selc.getId();
		coor = cDAO.pegarId(i);
		if (coor != null) {
			System.out.println("deu");
		} else {
			System.out.println("não deu");
		}
	}

	public void excluirCoordenador() {

	}

	private void listarC() {
		coo = cDAO.listarTodos();
	}

	public void dlCoor() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado", "Coordenador foi deletado com sucesso."));
	}

	public void errorCoor() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Coordenador não pode ser deletado."));
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

	public coordenadorDAO getcDAO() {
		return cDAO;
	}

	public void setcDAO(coordenadorDAO cDAO) {
		this.cDAO = cDAO;
	}

	public Coordenador getSelc() {
		return selc;
	}

	public void setSelc(Coordenador selc) {
		this.selc = selc;
	}

}