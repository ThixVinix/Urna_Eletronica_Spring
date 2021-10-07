package br.com.proway.turmab.grupo5.urnaEletronica.model;

public class Usuario {

	private Long id;
	/** Login -> email */
	private String login;
	private String password;

	public Usuario() {

	}

	public Usuario(String login, String password) {
		super();
		this.setLogin(login);
		this.setPassword(password);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
