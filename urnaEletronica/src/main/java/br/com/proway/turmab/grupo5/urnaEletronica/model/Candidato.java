package br.com.proway.turmab.grupo5.urnaEletronica.model;

public class Candidato {

	private Long id;
	private String nome;
	private Integer numero;
	private String urlImagem;

	public Candidato() {

	}

	public Candidato(String nome, Integer numero, String urlImagem) {
		this.nome = nome;
		this.numero = numero;
		this.urlImagem = urlImagem;
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

	public Long getId() {
		return id;
	}

}
