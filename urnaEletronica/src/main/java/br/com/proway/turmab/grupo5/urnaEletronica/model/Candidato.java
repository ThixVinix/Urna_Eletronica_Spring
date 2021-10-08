package br.com.proway.turmab.grupo5.urnaEletronica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidatos")
public class Candidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", columnDefinition = "VARCHAR", unique = false, updatable = true, nullable = false)
	private String nome;
	
	@Column(name = "numero", columnDefinition = "SMALLINT", unique = false, updatable = false, nullable = false)
	private Integer numero;
	
	@Column(name = "url_imagem", columnDefinition = "VARCHAR", unique = false, updatable = true, nullable = false)
	private String urlImagem;

	public Candidato() {

	}

	public Candidato(String nome, Integer numero, String urlImagem) {
		super();
		this.setNome(nome);
		this.setNumero(numero);
		this.setUrlImagem(urlImagem);
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

}
