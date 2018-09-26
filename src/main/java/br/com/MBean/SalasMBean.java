package br.com.MBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.DAO.salaDAO;
import br.com.entities.Salas;

@ManagedBean
@RequestScoped
public class SalasMBean {
	
	Salas sal;
	List<Salas> Lsal;
	salaDAO sDAO;
	
	public SalasMBean() {
		
	}
	

}
