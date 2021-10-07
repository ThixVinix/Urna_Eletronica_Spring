package br.com.proway.turmab.grupo5.urnaEletronica.model;

import java.time.LocalDate;

public class Voto {
	private Long id;
	private String rg;
	private String nome;
	private Integer numero;
	private LocalDate data;

	public Voto() {

	}

	public Voto(String rg, String nome, Integer numero) {
		super();
		setRg(rg);
		setNome(nome);
		setNumero(numero);
		this.data = LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
