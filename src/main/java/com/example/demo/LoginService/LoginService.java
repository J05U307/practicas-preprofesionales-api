package com.example.demo.LoginService;

import com.example.demo.dto.Login;

public interface LoginService {

    String login(Login login);

    Long getUserId(Login login);

    String getUserRole(Login login);
    
    String getUserNombre(Login login);
    
    String getUserApellidos(Login login);
    
    Long getCarrera_Persona_id(Login login);
}
