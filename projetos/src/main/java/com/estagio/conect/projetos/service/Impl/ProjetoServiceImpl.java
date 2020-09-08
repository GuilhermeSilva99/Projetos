package com.estagio.conect.projetos.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estagio.conect.projetos.model.Projeto;
import com.estagio.conect.projetos.repository.ProjetoRepository;
import com.estagio.conect.projetos.service.ProjetoService;

@Service
public class ProjetoServiceImpl implements ProjetoService{
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Override
	public List<Projeto> obterTodos() {
		return this.projetoRepository.findAll();
	}

	@Override
	public Projeto obterPorCodigo(String codigo) {
		return this.projetoRepository
				.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Projeto não existe"));
	}

	@Override
	public Projeto criar(Projeto projeto) {
		if(projeto.getSubProjeto() != null) {
			Projeto subProjeto = 
					this.projetoRepository
					.findById(projeto.getSubProjeto().getCodigo())
					.orElseThrow(() -> new IllegalArgumentException("SubProjeto inexiste"));
			projeto.setSubProjeto(subProjeto);
		}		
		return this.projetoRepository.save(projeto);
	}

	@Override
	public List<Projeto> obterProjetoPorRangeDeDuracao(Integer de, Integer ate) {
		return this.projetoRepository.obterProjetoPorRangeDeDuracao(de, ate);
	}

	@Override
	public List<Projeto> obterProjetoPorNome(String nome) {
		return this.projetoRepository.findByNome(nome);
	}

	@Override
	public void deleteByID(String codigo) {
		this.projetoRepository.deleteById(codigo);
	}

	@Override
	public Projeto atualizarProjeto(Projeto projeto) {
		return this.projetoRepository.save(projeto);
	}

	

}
