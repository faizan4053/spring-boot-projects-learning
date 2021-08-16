package com.eldorado.authservice.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;


public class AuthUserDetails extends AuthUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	
	public AuthUserDetails(AuthUser user) {
		super(user);
	}
	
	
	/**
	 * @author Mohammad faizan
	 * 
	 * returns the granted authority for each users   
	 */

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthority = new ArrayList<>();
		
		getRoles().forEach(role->{
			grantedAuthority.add(new SimpleGrantedAuthority(role.getName()));		
//			role.getPermission().forEach(permission -> {
//				grantedAuthority.add(new SimpleGrantedAuthority(permission.getName()));
//			});
		});
		return grantedAuthority;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

//	@Override
//	public String getUsername() {
//		return super.getUsername();
//	}

	@Override
	public boolean isAccountNonExpired() {
		return super.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return super.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled();
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
