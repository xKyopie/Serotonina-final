package br.edu.ifsp.login_spring.controller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.login_spring.model.User;
import br.edu.ifsp.login_spring.repository.UserRepository;
import br.edu.ifsp.login_spring.security.jwt.JwtUtils;
import io.jsonwebtoken.Header;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody User usuarioNovo){
        // Se encontrar no banco, não poderá criar um novo usuário
        boolean exists = userRepository.findByUsername(usuarioNovo.getUsername()).stream().count() > 0;
        // Mas não existir, cra o novo usuário no banco
        if(!exists){
            //criptografa a senha do usuário para por no banco de dados
            usuarioNovo.setPassword(
                passwordEncoder.encode(usuarioNovo.getPassword())
            );
            userRepository.save(usuarioNovo);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();    
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return (List<User>)userRepository.findAll();
    }
    
    @GetMapping("/user/me")
    public User getMyInformations(@RequestHeader("Authorization") String token){
        // String token = headers.firstValue("Authorization").get();
        System.out.println(token);
        token = token.substring(7, token.length());
        String username = jwtUtils.getUserNameFromJwtToken(token);
        return userRepository.findByUsername(username).get(0);
    }
}
