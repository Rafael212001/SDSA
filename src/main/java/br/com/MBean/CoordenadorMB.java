package br.com.MBean;

import java.nio.channels.ShutdownChannelGroupException;
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
	Coordenador selc;
	coordenadorDAO cDAO = new coordenadorDAO();
	List<Coordenador> coo;

	public CoordenadorMB() {
		listarC();
	}

	public void showSuccessMessage(String Message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                Message, null));
    }         
	
	 public void showErrorMessage(String Message) {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
	                Message, null));
	    }

	
	public void salvar() {
		if (coor.getSenha().equals(coor.getConfirmar_senha())) {
			if(coor.getId() != null) {
				Coordenador c = cDAO.buscaCoordenador(coor.getId());
				if (c != null && c.getId().equals(coor.getId())) {
					editarCoordenador();
				}
			}else {
				criarCoordenador();

			}
		}else {
			System.out.println("ERRO");
		}
	}

	public void editarCoordenador() {
		if (cDAO.editar(coor)) {
			System.out.println("Coordenador alterado.");
			zerar();
			listarC();
		} else {
			System.out.println("Erro na alteração do coordenador.");
			listarC();
		}
	}
	
	
			

	public void criarCoordenador() {
		if (cDAO.inserir(coor)) {
			System.out.println("Coordenador criado.");
			zerar();
			listarC();
		} else {
			System.out.println("Erro na criação do coordenador.");
			listarC();
		}
	}

	private void zerar() {
		coor = new Coordenador();
		cDAO = new coordenadorDAO();
		selc = null;
	}

	public void editar() {
		coor = selc;
	}

	public void excluir() {
		if(cDAO.excluir(selc.getId())) {
			System.out.println("Coordenador " + selc.getNome() + " excluindo.");
			listarC();
		}
	}

	private void listarC() {
		coo = cDAO.listarTodos();
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