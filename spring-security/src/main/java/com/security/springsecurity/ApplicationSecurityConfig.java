package com.security.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public  ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder=passwordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
//			.csrf().disable()
			.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			.and()
			.authorizeRequests()
			.antMatchers("/","index","/js/*","/css/*").permitAll()
			.antMatchers("/api/**").hasRole(ApplicationUserRole.STUDENT.name())
//			.antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
//			.antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
//			.antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
//			.antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ApplicationUserRole.ADMIN.name(),ApplicationUserRole.ADMINTRAINEE.name())
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
//		return super.userDetailsService();
		UserDetails faizanUser=
			User.builder()
			.username("faizan")
			.password(passwordEncoder.encode("123"))
//			.roles("student") //role student
//			.roles(ApplicationUserRole.STUDENT.name()) //role student
			.authorities(ApplicationUserRole.STUDENT.getGrantedAuthority())
			.build();
		
		UserDetails rahulUser=
				User.builder()
				.username("rahul")
				.password(passwordEncoder.encode("123"))
//				.roles("admin") //role user
//				.roles(ApplicationUserRole.ADMIN.name()) //role user
				.authorities(ApplicationUserRole.ADMIN.getGrantedAuthority())
				.build();
		
		UserDetails yashUser=
				User.builder()
				.username("yash")
				.password(passwordEncoder.encode("123"))
//				.roles(ApplicationUserRole.ADMINTRAINEE.name()) //role user
				.authorities(ApplicationUserRole.ADMINTRAINEE.getGrantedAuthority())
				.build();
//		
		
		return new InMemoryUserDetailsManager(
					faizanUser,
					rahulUser,
					yashUser
				);
	}

}
