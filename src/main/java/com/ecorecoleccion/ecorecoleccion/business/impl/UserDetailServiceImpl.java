package com.ecorecoleccion.ecorecoleccion.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecorecoleccion.ecorecoleccion.dao.UsuariosRepository;
import com.ecorecoleccion.ecorecoleccion.dao.model.Usuario;

/**
 * Clase que implementa la interfaz UserDetailsService
 * @author yoiner.cabezas
 */
@Service("UsuarioDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuariosRepository repository;
	
	/**
	 * Metodo que obtiene usuario de BD y me retorna un usuario de spring
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByUsuario(username);
		System.out.println("USUARIO OBTENIDO ::: " + usuario.getUsuario());
		System.out.println("PASSWORD OBTENIDO ::: " + usuario.getPassword());
		System.out.println("ROL OBTENIDO ::: " + usuario.getRol());
		return this.userBuilder(username, new BCryptPasswordEncoder().encode(usuario.getPassword()),usuario.getRol());
	}
	
	/**
	 * Metodo que permite retornar un usuario de spring
	 * @param username
	 * @param password
	 * @param roles
	 * @return
	 */
	private User userBuilder(String username, String password, String... roles) {
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(String role:roles) {
			authorities.add(new SimpleGrantedAuthority(role));
			System.out.println("ROLES ::: " + role);
		}
		return new User(username,password, enabled, accountNonExpired,credentialsNonExpired, accountNonLocked,authorities);
	}
}
