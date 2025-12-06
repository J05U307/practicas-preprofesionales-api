package com.example.demo.LoginServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.LoginService.LoginService;
import com.example.demo.config.JwtTokenProvider;
import com.example.demo.dto.Login;
import com.example.demo.entity.Persona;
import com.example.demo.repository.PersonaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private PersonaRepository personaRepository;

	@PersistenceContext
	private EntityManager entityManager;

	// Metodos :

	@Override
	public String login(Login login) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(login.getUsuario(), login.getClave()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		// 03 - Generate the token based on username and secret key
		String token = jwtTokenProvider.generateToken(authentication);

		// 04 - Return the token to controller
		return token;
	}

	@Override
	public Long getUserId(Login login) {
		// Usa findByUsuario que devuelve un Optional<Persona>

		return personaRepository.findByUsuario(login.getUsuario()).map(Persona::getId_persona) // Si se encuentra,
																								// devuelve el
				// ID
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado")); // Si no, lanza excepción
	}

	@Override
	public String getUserRole(Login login) {

		String sql = "SELECT r.rol FROM ROLES r " + "JOIN ROL_PERSONA rp ON r.ID_ROL = rp.ID_ROL "
				+ "JOIN PERSONAS p ON rp.ID_PERSONA = p.ID_PERSONA " + "WHERE p.USUARIO = :usuario";

		Query query = entityManager.createNativeQuery(sql);
		query.setParameter("usuario", login.getUsuario());

		try {
			String rol = (String) query.getSingleResult();
			return rol;
		} catch (NoResultException e) {
			throw new RuntimeException("Usuario o rol no encontrado");
		}
	}

	@Override
	public String getUserNombre(Login login) {
		return personaRepository.findByUsuario(login.getUsuario()).map(Persona::getNombre) 
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado")); 
	}

	@Override
	public String getUserApellidos(Login login) {
		return personaRepository.findByUsuario(login.getUsuario()).map(Persona::getApellidos) 
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado")); 
	
	}

	@Override
	public Long getCarrera_Persona_id(Login login) {
	    String sql = "SELECT CP.ID_CARRERA_PERSONA " + 
	                 "FROM CARRERA_PESONA CP " + 
	                 "JOIN PERSONAS P ON CP.ID_PERSONA = P.ID_PERSONA " + 
	                 "WHERE P.USUARIO = :usuario";

	    Query query = entityManager.createNativeQuery(sql);
	    query.setParameter("usuario", login.getUsuario());
	    try {
	        Object resultado = query.getSingleResult();
	        
	        return ((Number) resultado).longValue();
	    } catch (NoResultException e) {
	    	return null; 
	    }
	}


}