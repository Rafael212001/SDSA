package br.com.MBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.DAO.professorDAO;
import br.com.entities.Professor;

@ManagedBean
@RequestScoped
public class ProfessorMB {
	List<Professor> prof;
	professorDAO pDAO = new professorDAO();

	public List<Professor> getProf() {
		return prof;
	}

	public void setProf(List<Professor> prof) {
		this.prof = prof;
	}
}