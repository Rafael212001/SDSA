package br.com.MBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.DragDropEvent;

import br.com.DAO.aulasDAO;
import br.com.DAO.disciplinaDAO;
import br.com.DAO.salaDAO;
import br.com.entities.Aulas;
import br.com.entities.Disciplina;
import br.com.entities.Salas;

@ManagedBean
@ViewScoped
public class DistribuicaoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Aulas> dropSala1;
	private List<Aulas> dropSala2;
	private List<Aulas> dropSala3;
	private List<Aulas> dropSala4;
	private List<Aulas> dropSala5;
	private List<Aulas> dropSala6;
	private List<Aulas> dropSala7;
	private List<Aulas> dropSala8;
	private List<Aulas> dropSala9;
	private List<Aulas> dropSala10;
	private List<Aulas> dropSala11;
	private List<Aulas> dropSala12;
	private List<Aulas> dropSala13;
	private List<Aulas> dropSala14;
	private List<Aulas> dropSala15;
	private List<Aulas> dropSala16;
	private List<Aulas> dropSala18;
	private List<Aulas> dropSala35;

	public List<String> horario;
	private Aulas selecionadas;
	private aulasDAO aDAO;
	private disciplinaDAO dDAO;
	private salaDAO sDAO;
	private Salas sala;
	public Integer dia_semana = 1;
	public Integer periodo = 1;
	private Aulas aulaExcluir;
	private Disciplina disc;
	private Aulas aula;
	private int salas = 0;
	boolean h1 = false;
	boolean h2 = false;
	boolean h3 = false;
	boolean h4 = false;
	boolean h5 = false;

	List<Aulas> aulas;

	public DistribuicaoMB() {
		aDAO = new aulasDAO();
		dDAO = new disciplinaDAO();
		sDAO = new salaDAO();
		atualizar();
	}

	public void atualizar() {
		System.out.println("Atualizando");
		aulas = aDAO.listarTodasSemSala();
		dropSala1 = aDAO.listarAulasAlocadas(dia_semana, 1, periodo);
		dropSala2 = aDAO.listarAulasAlocadas(dia_semana, 2, periodo);
		dropSala3 = aDAO.listarAulasAlocadas(dia_semana, 3, periodo);
		dropSala4 = aDAO.listarAulasAlocadas(dia_semana, 4, periodo);
		dropSala5 = aDAO.listarAulasAlocadas(dia_semana, 5, periodo);
		dropSala6 = aDAO.listarAulasAlocadas(dia_semana, 6, periodo);
		dropSala7 = aDAO.listarAulasAlocadas(dia_semana, 7, periodo);
		dropSala8 = aDAO.listarAulasAlocadas(dia_semana, 8, periodo);
		dropSala9 = aDAO.listarAulasAlocadas(dia_semana, 9, periodo);
		dropSala10 = aDAO.listarAulasAlocadas(dia_semana, 10, periodo);
		dropSala11 = aDAO.listarAulasAlocadas(dia_semana, 11, periodo);
		dropSala12 = aDAO.listarAulasAlocadas(dia_semana, 12, periodo);
		dropSala13 = aDAO.listarAulasAlocadas(dia_semana, 13, periodo);
		dropSala14 = aDAO.listarAulasAlocadas(dia_semana, 14, periodo);
		dropSala15 = aDAO.listarAulasAlocadas(dia_semana, 15, periodo);
		dropSala16 = aDAO.listarAulasAlocadas(dia_semana, 16, periodo);
		dropSala18 = aDAO.listarAulasAlocadas(dia_semana, 18, periodo);
		dropSala35 = aDAO.listarAulasAlocadas(dia_semana, 35, periodo);
		horario = new ArrayList<>();
		aula = new Aulas();
		salas = 0;
	}

	public void excluir() {
		aulaExcluir = aDAO.listarAulas(aulaExcluir.getId());
		aDAO.desalocar(aulaExcluir);
		aulas.remove(aulaExcluir);
		System.out.println("Retirando da sala.");
		atualizar();
		excluindo(aulaExcluir.getHorario());
	}

	public String salvandoAula() {
		int j = 0;
		aula = aDAO.listarAulas(aula.getId());
		if (aDAO.contarSala(salas, periodo, dia_semana) <= 4) {
			for (String i : horario) {
				aula.setId(aula.getId() + j);
				aDAO.alocarSala(aula, salas, dia_semana, periodo, i);
				aDAO.listarAulasAlocadas(dia_semana, salas, periodo);
				dropSala1.add(aula);
				aulas.remove(aula);
				j = 1;
			}
			return "telaDistribuicao?faces-redirect=true";
		} else {
			System.out.println("maximo de aulas na sala");
			return "telaDistribuicao?faces-redirect=true";
		}
	}

	public void onAulasDropSala1(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 1;
		habilitado();
	}

	public void onAulasDropSala2(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 2;
		habilitado();
	}

	public void onAulasDropSala3(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 3;
		habilitado();
	}

	public void onAulasDropSala4(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 4;
		habilitado();
	}

	public void onAulasDropSala5(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 5;
		habilitado();
	}

	public void onAulasDropSala6(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 6;
		habilitado();
	}

	public void onAulasDropSala7(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 7;
		habilitado();
	}

	public void onAulasDropSala8(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 8;
		habilitado();
	}

	public void onAulasDropSala9(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 9;
		habilitado();
	}

	public void onAulasDropSala10(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 10;
		habilitado();
	}

	public void onAulasDropSala11(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 11;
		habilitado();
	}

	public void onAulasDropSala12(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 12;
		habilitado();
	}

	public void onAulasDropSala13(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 13;
		habilitado();
	}

	public void onAulasDropSala14(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 14;
		habilitado();
	}

	public void onAulasDropSala15(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 15;
		habilitado();
	}

	public void onAulasDropSala16(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 15;
		habilitado();
	}

	public void onAulasDropSala18(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 18;
		habilitado();
	}

	public void onAulasDropSala35(DragDropEvent dde) {
		aula = ((Aulas) dde.getData());
		salas = 35;
		habilitado();
	}

	public void habilitado() {
		h1 = false;
		h2 = false;
		h3 = false;
		h4 = false;
		h5 = false;
		desabilitado();
	}
	
	@SuppressWarnings("deprecation")
	public void desabilitado() {
		List<Aulas> H = aDAO.verAulas(salas, periodo, dia_semana);
		for (Aulas j : H) {
			if (j.getHorario().equals("0")) {
				h1 = true;
			} else if (j.getHorario().equals("1")) {
				h2 = true;
			} else if (j.getHorario().equals("2")) {
				h3 = true;
			} else if (j.getHorario().equals("3")) {
				h4 = true;
			} else {
				h5 = true;
			}
		}
		RequestContext.getCurrentInstance().update("dialog:checar");
	}
	
	@SuppressWarnings("deprecation")
	private void excluindo(String h) {
		if (h.equals("0")) {
			h1 = false;
		} else if (h.equals("1")) {
			h2 = false;
		} else if (h.equals("2")) {
			h3 = false;
		} else if (h.equals("3")) {
			h4 = false;
		} else {
			h5 = false;
		}
		RequestContext.getCurrentInstance().update("dialog:checar");
	}

	public void onAulasDropLixeira(DragDropEvent dde) {
		Aulas a = new Aulas();
		Aulas aula = ((Aulas) dde.getData());
		a = aDAO.listarAulas(aula.getId());
		if (aDAO.excluir(a)) {
			aulas.remove(aula);
			System.out.println("Aula excluida.");
		} else {
			System.out.println("Erro ao excluir.");
		}
	}

	public Aulas getSelecionadas() {
		return selecionadas;
	}

	public void setSelecionadas(Aulas selecionadas) {
		this.selecionadas = selecionadas;
	}

	public aulasDAO getaDAO() {
		return aDAO;
	}

	public void setaDAO(aulasDAO aDAO) {
		this.aDAO = aDAO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Aulas> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aulas> aulas) {
		this.aulas = aulas;
	}

	public List<Aulas> getDropSala1() {
		return dropSala1;
	}

	public void setDropSala1(List<Aulas> dropSala1) {
		this.dropSala1 = dropSala1;
	}

	public List<Aulas> getDropSala2() {
		return dropSala2;
	}

	public void setDropSala2(List<Aulas> dropSala2) {
		this.dropSala2 = dropSala2;
	}

	public List<Aulas> getDropSala3() {
		return dropSala3;
	}

	public void setDropSala3(List<Aulas> dropSala3) {
		this.dropSala3 = dropSala3;
	}

	public List<Aulas> getDropSala4() {
		return dropSala4;
	}

	public void setDropSala4(List<Aulas> dropSala4) {
		this.dropSala4 = dropSala4;
	}

	public List<Aulas> getDropSala5() {
		return dropSala5;
	}

	public void setDropSala5(List<Aulas> dropSala5) {
		this.dropSala5 = dropSala5;
	}

	public List<Aulas> getDropSala6() {
		return dropSala6;
	}

	public void setDropSala6(List<Aulas> dropSala6) {
		this.dropSala6 = dropSala6;
	}

	public List<Aulas> getDropSala7() {
		return dropSala7;
	}

	public void setDropSala7(List<Aulas> dropSala7) {
		this.dropSala7 = dropSala7;
	}

	public List<Aulas> getDropSala8() {
		return dropSala8;
	}

	public void setDropSala8(List<Aulas> dropSala8) {
		this.dropSala8 = dropSala8;
	}

	public List<Aulas> getDropSala9() {
		return dropSala9;
	}

	public void setDropSala9(List<Aulas> dropSala9) {
		this.dropSala9 = dropSala9;
	}

	public List<Aulas> getDropSala10() {
		return dropSala10;
	}

	public void setDropSala10(List<Aulas> dropSala10) {
		this.dropSala10 = dropSala10;
	}

	public List<Aulas> getDropSala11() {
		return dropSala11;
	}

	public void setDropSala11(List<Aulas> dropSala11) {
		this.dropSala11 = dropSala11;
	}

	public List<Aulas> getDropSala12() {
		return dropSala12;
	}

	public void setDropSala12(List<Aulas> dropSala12) {
		this.dropSala12 = dropSala12;
	}

	public List<Aulas> getDropSala13() {
		return dropSala13;
	}

	public void setDropSala13(List<Aulas> dropSala13) {
		this.dropSala13 = dropSala13;
	}

	public List<Aulas> getDropSala14() {
		return dropSala14;
	}

	public void setDropSala14(List<Aulas> dropSala14) {
		this.dropSala14 = dropSala14;
	}

	public List<Aulas> getDropSala15() {
		return dropSala15;
	}

	public void setDropSala15(List<Aulas> dropSala15) {
		this.dropSala15 = dropSala15;
	}

	public List<Aulas> getDropSala16() {
		return dropSala16;
	}

	public void setDropSala16(List<Aulas> dropSala16) {
		this.dropSala16 = dropSala16;
	}

	public List<Aulas> getDropSala18() {
		return dropSala18;
	}

	public void setDropSala18(List<Aulas> dropSala18) {
		this.dropSala18 = dropSala18;
	}

	public List<Aulas> getDropSala35() {
		return dropSala35;
	}

	public void setDropSala35(List<Aulas> dropSala35) {
		this.dropSala35 = dropSala35;
	}

	public Salas getSala() {
		return sala;
	}

	public void setSala(Salas sala) {
		this.sala = sala;
	}

	public Integer getDia_semana() {
		return dia_semana;
	}

	public void setDia_semana(Integer dia_semana) {
		this.dia_semana = dia_semana;
	}

	public Aulas getAulaExcluir() {
		return aulaExcluir;
	}

	public void setAulaExcluir(Aulas aulaExcluir) {
		this.aulaExcluir = aulaExcluir;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public disciplinaDAO getdDAO() {
		return dDAO;
	}

	public void setdDAO(disciplinaDAO dDAO) {
		this.dDAO = dDAO;
	}

	public Disciplina getDisc() {
		return disc;
	}

	public void setDisc(Disciplina disc) {
		this.disc = disc;
	}

	public salaDAO getsDAO() {
		return sDAO;
	}

	public void setsDAO(salaDAO sDAO) {
		this.sDAO = sDAO;
	}

	public List<String> getHorario() {
		return horario;
	}

	public void setHorario(List<String> horario) {
		this.horario = horario;
	}

	public Aulas getAula() {
		return aula;
	}

	public void setAula(Aulas aula) {
		this.aula = aula;
	}

	public int getSalas() {
		return salas;
	}

	public void setSalas(int salas) {
		this.salas = salas;
	}

	public boolean isH1() {
		return h1;
	}

	public void setH1(boolean h1) {
		this.h1 = h1;
	}

	public boolean isH2() {
		return h2;
	}

	public void setH2(boolean h2) {
		this.h2 = h2;
	}

	public boolean isH3() {
		return h3;
	}

	public void setH3(boolean h3) {
		this.h3 = h3;
	}

	public boolean isH4() {
		return h4;
	}

	public void setH4(boolean h4) {
		this.h4 = h4;
	}

	public boolean isH5() {
		return h5;
	}

	public void setH5(boolean h5) {
		this.h5 = h5;
	}
}
