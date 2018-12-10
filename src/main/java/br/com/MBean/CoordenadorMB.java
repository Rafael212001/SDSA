package br.com.MBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.DAO.coordenadorDAO;
import br.com.entities.Coordenador;

@ManagedBean
@ViewScoped
public class CoordenadorMB {
	Coordenador coor = new Coordenador();
	Coordenador selc;
	coordenadorDAO cDAO = new coordenadorDAO();
	List<Coordenador> coo;
	FacesContext context;

	public CoordenadorMB() {
		listarC();
	}

	public void salvar() {
		context = FacesContext.getCurrentInstance();
		if (coor.getId() != null) {
			Coordenador c = cDAO.buscaCoordenador(coor.getId());
			if (c != null && c.getId().equals(coor.getId())) {
				editarCoordenador();
			}
		} else {
			criarCoordenador();

		}
	}

	public void editarCoordenador() {
		if (testarCampos()) {
			if (coor.getSenha().equals(coor.getConfirmar_senha())) {
				if (cDAO.editar(coor)) {
					System.out.println("Coordenador alterado.");
					context.addMessage(null, new FacesMessage("Sucesso", "Coordenador alterado."));
					zerar();
					listarC();
				} else {
					System.out.println("Erro na alteração do coordenador.");
					context.addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro na alteração do coordenador."));
					listarC();
				}
			} else {
				System.out.println("Senhas não estão batendo");
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Senha", "A senha não está igual."));
			}
		} else {
			System.out.println("Campo vazio.");
		}
	}

	public void criarCoordenador() {
		if (testarCampos()) {
			if (coor.getSenha().equals(coor.getConfirmar_senha())) {
				if (cDAO.inserir(coor)) {
					System.out.println("Coordenador criado.");
					context.addMessage(null, new FacesMessage("Sucesso", "Coordenador criado."));
					zerar();
					listarC();
				} else {
					System.out.println("Erro na criação do coordenador.");
					context.addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro na criação do coordenador."));
					listarC();
				}
			} else {
				System.out.println("Senhas não estão batendo");
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Senha", "A senha não está igual."));
			}
		} else {
			System.out.println("Campo vazio.");
		}
	}

	private boolean testarCampos() {
		if ((coor.getNome().equals("")) || (coor.getLogin().equals("")) || (coor.getSenha().equals(""))
				|| (coor.getConfirmar_senha().equals(""))) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Campo(s) vazio(s)", "Algum campo está vazio."));
			return false;
		} else {
			return true;
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
		context = FacesContext.getCurrentInstance();
		if (cDAO.excluir(selc.getId())) {
			System.out.println("Coordenador " + selc.getNome() + " excluindo.");
			context.addMessage(null, new FacesMessage("Excluido", "Coordenador " + selc.getNome() + " excluido."));
			listarC();
			zerar();
		} else {
			System.out.println("Erro ao tentar excluir coordenador.");
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao tentar excluir coordenador."));
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