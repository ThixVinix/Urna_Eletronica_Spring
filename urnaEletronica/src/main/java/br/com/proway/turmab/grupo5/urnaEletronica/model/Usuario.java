package br.com.proway.turmab.grupo5.urnaEletronica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/** Login -> email */
	@Column(name = "login", columnDefinition = "VARCHAR", unique = true, updatable = false, nullable = false)
	private String login;
	@Column(name = "password", columnDefinition = "VARCHAR", unique = true, updatable = true, nullable = false)
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
