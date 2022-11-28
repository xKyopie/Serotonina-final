package br.edu.ifsp.login_spring.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifsp.login_spring.model.CadastroUsuario;

public interface CadastroUsuarioRepository extends CrudRepository<CadastroUsuario, Long>{
    
}
