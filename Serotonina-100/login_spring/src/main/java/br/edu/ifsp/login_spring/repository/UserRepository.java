package br.edu.ifsp.login_spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifsp.login_spring.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByUsername(String username);
}
