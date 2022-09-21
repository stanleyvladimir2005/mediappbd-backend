package com.mitocode.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mitocode.model.Rol;
import com.mitocode.model.Usuario;
import com.mitocode.repo.IUsuarioRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepo.findOneByUsername(userName)
				            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con ese UserName : " + userName));// TODO Auto-generated method stub
		return new User(usuario.getUsername(), usuario.getPassword(), mapearRoles(usuario.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapearRoles(Set<Rol> set){
		return set.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
	}
}