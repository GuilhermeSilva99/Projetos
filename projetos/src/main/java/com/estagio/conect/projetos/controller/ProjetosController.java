package com.estagio.conect.projetos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estagio.conect.projetos.model.Projeto;
import com.estagio.conect.projetos.service.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetosController {
	
	@Autowired
	private ProjetoService projetoService;
	
	@GetMapping
	public List<Projeto> obterTodos(){
		return this.projetoService.obterTodos();
	}

	@GetMapping("/{codigo}")
	public Projeto obterPorCodigo(@PathVariable String codigo){
		return this.projetoService.obterPorCodigo(codigo);
	}
	@PostMapping
	public Projeto criar(@RequestBody Projeto projeto){
		return this.projetoService.criar(projeto);
	}
	
	@GetMapping("/range")
	public List<Projeto> obterProjetoPorRangeDeDuracao(
			@RequestParam("de") Integer de,
			@RequestParam("ate") Integer ate){
		return this.projetoService.obterProjetoPorRangeDeDuracao(de, ate);
	}
	@GetMapping("/por-nome")
	public List<Projeto> obterProjetoPorNome(
			@RequestParam("nome") String nome){
		return this.projetoService.obterProjetoPorNome(nome);
	}
	@DeleteMapping("/delete/{codigo}")
	public Projeto deleteProjeto(@PathVariable String codigo) {
		Projeto deletado = this.projetoService.obterPorCodigo(codigo);
		this.projetoService.deleteByID(codigo);
		return deletado;
	}
	@PutMapping
	public Projeto atializarProjeto(@RequestBody Projeto projeto) {		
		return this.projetoService.atualizarProjeto(projeto);
	}
	
}
