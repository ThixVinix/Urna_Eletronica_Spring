package br.com.proway.turmab.grupo5.urnaEletronica.form;

import br.com.proway.turmab.grupo5.urnaEletronica.model.Usuario;

public class UsuarioForm {
	private Long id;
	/** Login -> email */
	private String login;
	private String password;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Usuario conveter() {
		return new Usuario(this.login, this.password);
		
	}
	

}
