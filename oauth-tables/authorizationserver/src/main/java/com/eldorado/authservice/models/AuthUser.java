package com.eldorado.authservice.models;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/*
 * AuthUser :Pojo class for User
 */

@Entity
public class AuthUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name = "enabled")
	private boolean enabled;
	@Column(name = "accountNonExpired")
	private boolean accountNonExpired;
	@Column(name = "credentialsNonExpired")
	private boolean credentialsNonExpired;
	@Column(name = "accountNonLocked")
	private boolean accountNonLocked;

	/*
	 * Many to Many mapping between user and role entities
	 */

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public AuthUser() {

	}

	public AuthUser(AuthUser user) {
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.enabled = user.isEnabled();
		this.accountNonExpired = user.isAccountNonExpired();
		this.credentialsNonExpired = user.isCredentialsNonExpired();
		this.accountNonLocked = user.isAccountNonLocked();
		this.roles = user.getRoles();
	}
	
	
	/*
	 * Return Type:boolean 
	 * Value :is user enabled
	 */

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Long getId() {
		return id;
	}

	/*
	 * Return Type:Long Value :user id
	 */

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * Return Type:String Value :user first name
	 */

	public String getFirstName() {
		return firstName;
	}

	/*
	 * Function to set the user first name Return Type:void
	 * 
	 */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/*
	 * Return Type:String Value :user last name
	 */

	public String getLastName() {
		return lastName;
	}

	/*
	 * Return Type:Long 
	 * Value :User Last Name
	 */

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * Function to get user Email Return Type:String Value :user email
	 */

	public String getEmail() {
		return email;
	}

	/*
	 * Function to set user email Return Type:void
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * Function to get user password Return Type:String Value :user password
	 */

	public String getPassword() {
		return password;
	}

	/*
	 * Function to set user password Return Type:void
	 */

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * Function to get user roles Return Type:Set Value :user roles set
	 */

	public Set<Role> getRoles() {
		return roles;
	}

	/*
	 * Function to set user roles Return Type:void
	 * 
	 */

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
