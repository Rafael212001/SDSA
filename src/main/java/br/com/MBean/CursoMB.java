package br.com.MBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.DAO.cursoDAO;
import br.com.entities.Curso;
import br.com.entities.Disciplina;

@ManagedBean
@ViewScoped
public class CursoMB {
	Curso cur = new Curso();
	Curso selc;
	Disciplina d = new Disciplina();
	List<Curso> curL;
	List<Curso> lista;
	cursoDAO csDAO = new cursoDAO();
	@ManagedProperty(value = "#{disciplinaMB}")
	DisciplinaMB dMB;
	int lastId;
	FacesContext context;

	public CursoMB() {
		listarCS();
	}
	
	public void salvar() {
		context = FacesContext.getCurrentInstance();
		if(cur.getId() != null) {
			Curso c = csDAO.buscarCurso(cur.getId());
			if(c != null && c.getId().equals(cur.getId())) {
				editarCurso();
			}
		}else {
			criarCurso();
		}
	}
	
	public void editarCurso() {
		if(csDAO.editar(cur)) {
			System.out.println("Curso alterado.");
			context.addMessage(null, new FacesMessage("Sucesso", "Curso alterado."));
			zerar();
			listarCS();
		}else {
			System.out.println("Erro na altera��o do curso.");
			context.addMessage(null, new FacesMessage("Campo(s) vazio(s)", "Algum campo est� vazio."));
			listarCS();
		}
	}
	
	public void criarCurso() {
		if(testarCampos()) {
			lastId = csDAO.inserir(cur);
				if (lastId > 0) {
					System.out.println("Curso criado.");
					context.addMessage(null, new FacesMessage("Sucesso", "Curso criado."));
					zerar();
					listarCS();
				} else {
					System.out.println("Erro na cria��o do curso.");
					context.addMessage(null, new FacesMessage("Erro", "Erro na cria��o do curso."));
					listarCS();
				}
		}else {
			System.out.println("Campo vazio.");
		}
	}
	
	private boolean testarCampos() {
		if((cur.getNome().equals("")) || (cur.getQtd_semestre() == null)) {
			context.addMessage(null, new FacesMessage("Campo(s) vazio(s)", "Algum campo est� vazio."));
			return false;
		}else {
			return true;
		}
	}
	
	public void disciplina() {
		dMB.setID(selc.getId());
		dMB.listarSemestreC();
		dMB.listarD();
	}

	private void zerar() {
		cur = new Curso();
		d = new Disciplina();
		csDAO = new cursoDAO();
		selc = null;
	}
	
	public void editar() {
		cur = selc;
	}
	
	public void excluir() {
		context = FacesContext.getCurrentInstance();
		if(csDAO.excluir(selc.getId())){
			System.out.println("Curso " +selc.getNome()+ " excluido.");
			context.addMessage(null, new FacesMessage("Excluido", "Curso " +selc.getNome()+ " excluido."));
			listarCS();
			zerar();
		}else {
			context.addMessage(null, new FacesMessage("Erro", "� necess�rio excluir as disciplinas deste curso antes de exclui-lo."));
		}
	}
	
	public String fechar() {
		zerar();
		listarCS();
		return "telaCoordenador";
	}

	private void listarCS() {
		curL = csDAO.listarTodos();
	}

	public Curso getCur() {
		return cur;
	}

	public void setCur(Curso cur) {
		this.cur = cur;
	}

	public List<Curso> getCurL() {
		return curL;
	}

	public void setCurL(List<Curso> curL) {
		this.curL = curL;
	}

	public cursoDAO getCsDAO() {
		return csDAO;
	}

	public void setCsDAO(cursoDAO csDAO) {
		this.csDAO = csDAO;
	}

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}

	public Disciplina getD() {
		return d;
	}

	public void setD(Disciplina d) {
		this.d = d;
	}

	public DisciplinaMB getdMB() {
		return dMB;
	}

	public void setdMB(DisciplinaMB dMB) {
		this.dMB = dMB;
	}

	public Curso getSelc() {
		return selc;
	}

	public void setSelc(Curso selc) {
		this.selc = selc;
	}

	public List<Curso> getLista() {
		return lista;
	}

	public void setLista(List<Curso> lista) {
		this.lista = lista;
	}

}
