package br.edu.ifsp.login_spring.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifsp.login_spring.model.Tarefa;


public interface TarefaRepository extends CrudRepository<Tarefa, Long> {
    
}