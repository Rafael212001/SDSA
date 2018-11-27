package br.com.entities;

public class Coordenador {

	private Integer id;
	private String nome;
	private String login;
	private String senha;
	private String confirmar_senha;

	public Coordenador() {
		// TODO Auto-generated constructor stub
	}
	
	public Coordenador(Integer id, String nome, String login, String senha, String confirmar_senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.confirmar_senha = confirmar_senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmar_senha() {
		return confirmar_senha;
	}

	public void setConfirmar_senha(String confirmar_senha) {
		this.confirmar_senha = confirmar_senha;
	}
}