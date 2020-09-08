package com.estagio.conect.projetos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Projeto {
	
	@Id
	private String codigo;
	
	private String nome;
	
	private String descricao;
	
	private Integer duracao;
	
	@DBRef
	private Projeto subProjeto;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Projeto getSubProjeto() {
		return subProjeto;
	}

	public void setSubProjeto(Projeto subProjeto) {
		this.subProjeto = subProjeto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getduracao() {
		return duracao;
	}

	public void setduracao(Integer duracao) {
		this.duracao = duracao;
	}
	
}
