package com.estagio.conect.projetos.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.estagio.conect.projetos.model.Projeto;

public interface ProjetoRepository extends MongoRepository<Projeto, String> {
	
	@Query("{ $and: [ { 'duracao': { $gte: ?0 } }, { 'duracao': { $lte: ?1 } } ] }")
	public List<Projeto> obterProjetoPorRangeDeDuracao(Integer de, Integer ate);
	
	public List<Projeto> findByNome(String nome);

}
