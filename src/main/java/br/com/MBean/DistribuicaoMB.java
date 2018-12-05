package br.com.MBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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

	private Aulas selecionadas;
	private aulasDAO aDAO;
	private disciplinaDAO dDAO;
	private salaDAO sDAO;
	private Salas sala;
	public Integer dia_semana = 1;
	public Integer periodo = 1;
	private Integer carga;
	private Aulas aulaExcluir;
	private Disciplina disc;

	List<Aulas> aulas;

	public DistribuicaoMB() {
		System.out.println("entrou");
		aDAO = new aulasDAO();
		dDAO = new disciplinaDAO();
		sDAO = new salaDAO();
		aulas = aDAO.listarTodasSemSala();
		atualizar();
	}

	public void atualizar() {
		System.out.println("entrou");
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
	}

	public String excluir() {
		aulaExcluir = aDAO.listarAulas(aulaExcluir.getId());
		int i;
		if (periodo == 1) {
			i = sDAO.listarContadorM(aulaExcluir.getId_sala());
			sDAO.diminuirContadorM(aulaExcluir.getId_sala(), i);
		} else if (periodo == 2) {
			i = sDAO.listarContadorT(aulaExcluir.getId_sala());
			sDAO.diminuirContadorT(aulaExcluir.getId_sala(), i);
		} else {
			i = sDAO.listarContadorN(aulaExcluir.getId_sala());
			sDAO.diminuirContadorN(aulaExcluir.getId_sala(), i);
		}

		aDAO.desalocar(aulaExcluir);
		aulas.remove(aulaExcluir);
		return "telaDistribuicao?faces-redirect=true";
	}

	public void onAulasDropSala1(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(1);
		if (i <= 4) {
			aDAO.alocarSala(aula, 1, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 1, periodo);

			dropSala1.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(1, i);
		}
	}

/////////////////////////////////////////////////////////////////////////////
	public void onAulasDropSala2(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(2);
		if (i <= 4) {
			aDAO.alocarSala(aula, 2, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 2, periodo);

			dropSala2.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(2, i);
		}

	}

///////////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala3(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int i;
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();

		if (periodo == 1) {
			i = sDAO.listarContadorM(3);
		} else if (periodo == 2) {
			i = sDAO.listarContadorT(3);
		} else {
			i = sDAO.listarContadorN(3);
		}

		if (i <= 4) {
			aDAO.alocarSala(aula, 3, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 3, periodo);

			dropSala3.add(aula);
			aulas.remove(aula);
			
			if (periodo == 1) {
				sDAO.almentarContadorM(3, i);
			} else if (periodo == 2) {
				sDAO.almentarContadorT(3, i);
			} else {
				sDAO.almentarContadorN(3, i);
			}
		}
	}

/////////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala4(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(4);
		if (i <= 4) {
			aDAO.alocarSala(aula, 4, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 4, periodo);

			dropSala4.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(4, i);
		}
	}

////////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala5(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(5);
		if (i <= 4) {
			aDAO.alocarSala(aula, 5, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 5, periodo);

			dropSala5.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(5, i);
		}
	}

////////////////////////////////////////////////////////////////////////////
	public void onAulasDropSala6(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(6);
		if (i <= 4) {
			aDAO.alocarSala(aula, 6, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 6, periodo);

			dropSala6.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(6, i);
		}
	}

////////////////////////////////////////////////////////////////////////////
	public void onAulasDropSala7(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(7);
		if (i <= 4) {
			aDAO.alocarSala(aula, 7, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 7, periodo);

			dropSala7.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(7, i);
		}
	}

////////////////////////////////////////////////////////////////////////////
	public void onAulasDropSala8(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(8);
		if (i <= 4) {
			aDAO.alocarSala(aula, 8, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 8, periodo);

			dropSala8.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(8, i);
		}
	}

///////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala9(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(9);
		if (i <= 4) {
			aDAO.alocarSala(aula, 9, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 9, periodo);

			dropSala9.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(9, i);
		}
	}

///////////////////////////////////////////////////////////////////////////		
	public void onAulasDropSala10(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(10);
		if (i <= 4) {
			aDAO.alocarSala(aula, 10, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 10, periodo);

			dropSala10.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(10, i);
		}
	}

///////////////////////////////////////////////////////////////////////////		
	public void onAulasDropSala11(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(11);
		if (i <= 4) {
			aDAO.alocarSala(aula, 11, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 11, periodo);

			dropSala11.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(11, i);
		}
	}

///////////////////////////////////////////////////////////////////////////		
	public void onAulasDropSala12(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(12);
		if (i <= 4) {
			aDAO.alocarSala(aula, 12, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 12, periodo);

			dropSala12.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(12, i);
		}
	}

///////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala13(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(13);
		if (i <= 4) {
			aDAO.alocarSala(aula, 13, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 13, periodo);

			dropSala13.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(13, i);
		}
	}

///////////////////////////////////////////////////////////////////////////		
	public void onAulasDropSala14(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(14);
		if (i <= 4) {
			aDAO.alocarSala(aula, 14, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 14, periodo);

			dropSala14.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(14, i);
		}
	}

///////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala15(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(15);
		if (i <= 4) {
			aDAO.alocarSala(aula, 15, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 15, periodo);

			dropSala15.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(15, i);
		}
	}

///////////////////////////////////////////////////////////////////////////	
	public void onAulasDropSala16(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(16);
		if (i <= 4) {
			aDAO.alocarSala(aula, 16, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 16, periodo);

			dropSala16.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(16, i);
		}
	}

///////////////////////////////////////////////////////////////////////////		
	public void onAulasDropSala18(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(18);
		if (i <= 4) {
			aDAO.alocarSala(aula, 18, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 18, periodo);

			dropSala18.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(18, i);
		}
	}

///////////////////////////////////////////////////////////////////////////		
	public void onAulasDropSala35(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());
		int d = aDAO.pegarIdDisciplina(aula.getId());
		disc = dDAO.buscarDisciplina(d);

		carga = disc.getCarga_hora();
		int i = sDAO.listarContador(35);
		if (i <= 4) {
			aDAO.alocarSala(aula, 35, dia_semana, carga, periodo, i);
			aDAO.listarAulasAlocadas(dia_semana, 35, periodo);

			dropSala35.add(aula);
			aulas.remove(aula);
			sDAO.almentarContador(35, i);
		}
	}

/////////////////////////////////////////////////////////////////////////////
	public void onAulasDropLixeira(DragDropEvent dde) {
		Aulas aula = ((Aulas) dde.getData());

		if (aDAO.excluir(aula)) {
			aulas.remove(aula);
			System.out.println("Aula excluida.");
		} else {
			System.out.println("Erro ao excluir.");
		}
	}

///////////////////////////////////////////////////////////////////////////	
	public void init() {
		// aulass = ;

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

	public Integer getCarga() {
		return carga;
	}

	public void setCarga(Integer carga) {
		this.carga = carga;
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
}
