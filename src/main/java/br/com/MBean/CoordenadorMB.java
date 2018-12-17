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
	Coordenador c;
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
			c = cDAO.buscaCoordenador(coor.getLogin());
			if (!c.getLogin().equals(coor.getLogin())) {
				if (coor.getSenha().equals(coor.getConfirmar_senha())) {
					if (cDAO.editar(coor)) {
						System.out.println("SDSA:Coordenador alterado.");
						context.addMessage(null, new FacesMessage("Sucesso", "Coordenador alterado."));
						zerar();
						listarC();
					} else {
						System.out.println("SDSA:Erro na altera��o do coordenador.");
						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
								"Erro na altera��o do coordenador."));
						listarC();
					}
				} else {
					System.out.println("SDSA:Senhas n�o est�o batendo");
					context.addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "Senha", "A senha n�o est� igual."));
				}
			} else {
				System.out.println("SDSA:Login repetido.");
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login repetido", "Esse login j� existe."));
			}
		} else {
			System.out.println("SDSA:Campo vazio.");
		}
	}

	public void criarCoordenador() {
		if (testarCampos()) {
			c = cDAO.buscaCoordenador(coor.getLogin());
			if (c == null) {
				if (coor.getSenha().equals(coor.getConfirmar_senha())) {
					if (cDAO.inserir(coor)) {
						System.out.println("SDSA:Coordenador criado.");
						context.addMessage(null, new FacesMessage("Sucesso", "Coordenador criado."));
						zerar();
						listarC();
					} else {
						System.out.println("SDSA:Erro na cria��o do coordenador.");
						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
								"Erro na cria��o do coordenador."));
						listarC();
					}
				} else {
					System.out.println("SDSA:Senhas n�o est�o batendo");
					context.addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "Senha", "A senha n�o est� igual."));
				}
			} else {
				System.out.println("SDSA:Login repetido.");
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login repetido", "Esse login j� existe."));
			}
		} else {
			System.out.println("SDSA:Campo vazio.");
		}
	}

	private boolean testarCampos() {
		if ((coor.getNome().equals("")) || (coor.getLogin().equals("")) || (coor.getSenha().equals(""))
				|| (coor.getConfirmar_senha().equals(""))) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Campo(s) vazio(s)", "Algum campo est� vazio."));
			return false;
		} else {
			return true;
		}
	}

	private void zerar() {
		coor = new Coordenador();
		cDAO = new coordenadorDAO();
		selc = null;
		c = null;
	}

	public void editar() {
		coor = selc;
	}

	public void excluir() {
		context = FacesContext.getCurrentInstance();
		if (cDAO.excluir(selc.getId())) {
			System.out.println("SDSA:Coordenador " + selc.getNome() + " excluindo.");
			context.addMessage(null, new FacesMessage("Excluido", "Coordenador " + selc.getNome() + " excluido."));
			listarC();
			zerar();
		} else {
			System.out.println("SDSA:Erro ao tentar excluir coordenador.");
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