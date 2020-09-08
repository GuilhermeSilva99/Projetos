package com.estagio.conect.projetos.service;

import java.util.List;

import com.estagio.conect.projetos.model.Projeto;

public interface ProjetoService {
	public List<Projeto> obterTodos();
	public Projeto obterPorCodigo(String codigo);
	public Projeto criar(Projeto projeto);
	public List<Projeto> obterProjetoPorRangeDeDuracao(Integer de, Integer ate);
	public List<Projeto> obterProjetoPorNome(String nome);
	public void deleteByID(String codigo);
	public Projeto atualizarProjeto(Projeto projeto);
}
