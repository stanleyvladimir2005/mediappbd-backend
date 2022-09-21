package com.mitocode.serviceImpl;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
//Para poder crear un validacion logica
public class RestAuthServiceImpl {

	public boolean hasAccess(String path) {
		boolean rpta = false;

		String metodoRol = switch (path) {
			case "listar" -> "ROLE_ADMIN";
			case "listarId" -> "ROLE_ADMIN,ROLE_USER";
			default -> "";

			// /listar
		};

		String[] metodoRoles;
		metodoRoles = metodoRol.split(",");

		Authentication autho = SecurityContextHolder.getContext().getAuthentication();
		if(!(autho instanceof AnonymousAuthenticationToken)) {
			System.out.println(autho.getName());
			
			for (GrantedAuthority auth : autho.getAuthorities()) {
				String rolUser = auth.getAuthority();
				System.out.println(rolUser);
				
				for (String rolMet : metodoRoles) {
					if (rolUser.equalsIgnoreCase(rolMet)) {
						rpta = true;
						break;
					}
				}
			}
		}
		return rpta;
	}
}
