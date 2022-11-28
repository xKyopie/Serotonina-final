package br.edu.ifsp.login_spring.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.login_spring.model.User;
import br.edu.ifsp.login_spring.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Encontra um usuário no banco de dados
        User user = userRepository.findByUsername(username).stream().findFirst().get();
        // Depois retorna um objeto UserDetailsImpl com base no usuário encontrado
        return new UserDetailsImpl(user);        
    } 
}
