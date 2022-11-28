package br.edu.ifsp.login_spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifsp.login_spring.model.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    List<Usuario> findByNomeUsuario(String nome);
}
