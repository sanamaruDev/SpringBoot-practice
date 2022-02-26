package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.demo.model.UserAccount;
import com.example.demo.service.UserAccountService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserAccountService userAccountService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		// ユーザアカウント情報取得
		List<UserAccount> result  = userAccountService.findAll();
		List<UserDetails> users = new ArrayList<UserDetails>();
		
		for (UserAccount userAccount : result) {
			UserDetails user =
				User.withDefaultPasswordEncoder()
					.username(userAccount.getCol1().toString())
					.password(userAccount.getCol2())
					.roles("USER")
					.build();
			users.add(user);
		}
		
		return new InMemoryUserDetailsManager(users);
	}
}
