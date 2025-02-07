package com.example.moattravel.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/css/**","/images/**","/js/**","/storage/**","/","/signup/**","/houses/{id}","/stripe/webhook").permitAll()
				//                            ユーザー指定
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated())
		
		.formLogin((form) -> form
				//ログインのURLを設定
				.loginPage("/login")
				//ログインフォームの送信先
				.loginProcessingUrl("/login")
				//ログイン成功時のリダイレクト先URL
				.defaultSuccessUrl("/?loggedIn")
				//ログイン失敗時のURL
				.failureUrl("/login?error").permitAll())
		
		.logout((logout) -> logout
				//ログアウト時　　　　　　　　　すべてのユーザー
				.logoutSuccessUrl("/?loggedOut").permitAll())
		.csrf((csrf) -> csrf.ignoringRequestMatchers("/stripe/webhook"));  // CSRFを無効化;
		
		return http.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}