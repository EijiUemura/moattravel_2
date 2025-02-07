package com.example.moattravel.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.moattravel.entity.User;

public class UserDetailslmpl implements UserDetails{
	private final User user;
	
	private final Collection<GrantedAuthority> authorities;
	
	public UserDetailslmpl (User user, Collection<GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}
	
	public User getUser() {
		return user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		return user.getEmail();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return user.getEnabled();
		
	}

}
