package com.example.demo.config;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Persona;
import com.example.demo.repository.PersonaRepository;


@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private PersonaRepository personaRepository;
  
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Persona user = personaRepository.findByUsuario(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

		Set<GrantedAuthority> authorities = user.getRoles().stream()
				.map((role) -> new SimpleGrantedAuthority(role.getRol()))
				.collect(Collectors.toSet());

		return new org.springframework.security.core.userdetails.User(
				username,
				user.getClave(), 
				authorities);
	
	
	}

}
