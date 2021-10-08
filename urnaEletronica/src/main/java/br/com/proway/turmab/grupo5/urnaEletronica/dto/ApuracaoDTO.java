package br.com.proway.turmab.grupo5.urnaEletronica.dto;

import br.com.proway.turmab.grupo5.urnaEletronica.model.Candidato;

public class ApuracaoDTO {
	
	private String nome;
	private Integer numero;
	private String urlImagem;
	private Integer votos;
	
	public ApuracaoDTO(Candidato candidato) {
		super();
		this.nome = candidato.getNome();
		this.numero = candidato.getNumero();
		this.urlImagem = candidato.getUrlImagem();
		this.votos = 0;
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

	public Integer getVotos() {
		return votos;
	}

	public void setVotos(Integer votos) {
		this.votos = votos;
	}
	

}
