package com.example.demo.LoginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.LoginService.LoginService;

import com.example.demo.dto.Token;

import com.example.demo.dto.Login;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class LoginController {

	@Autowired
	private LoginService authService;
	
	@PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody Login loginDto){

        //01 - Receive the token from AuthService
        String token = authService.login(loginDto);
        
        Long userId = authService.getUserId(loginDto);
        String role = authService.getUserRole(loginDto);
        String nombre = authService.getUserNombre(loginDto);
        String apellidos = authService.getUserApellidos(loginDto);
        Long Id_carrera_persona = authService.getCarrera_Persona_id(loginDto);
        

        //02 - Set the token as a response using JwtAuthResponse Dto class
        Token response = new Token();
        response.setToken(token);
        response.setUserId(userId);
        response.setRole(role);
        response.setNombre(nombre);
        response.setApellidos(apellidos);
        response.setCarrera_persona_id(Id_carrera_persona);
        
        //03 - Return the response to the user
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
