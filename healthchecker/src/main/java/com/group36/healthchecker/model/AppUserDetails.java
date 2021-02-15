package com.group36.healthchecker.model;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@DynamicUpdate
public class AppUserDetails implements UserDetails 
{

	private int id;
    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;
 
    public AppUserDetails(User2 user2) 
    {
    	this.id = user2.getId();
    	this.userName = user2.getUserName();
        this.password = user2.getPassword();
        this.active = user2.isActive();
        this.authorities = Arrays.stream(user2.getRoles().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {
        return authorities;
    }
    
    public int getId()
    {
    	return id;
    }
    
    @Override
    public String getPassword() 
    {
        return password;
    }

    @Override
    public String getUsername() 
    {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() 
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() 
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() 
    {
        return true;
    }

    @Override
    public boolean isEnabled() 
    {
        return active;
    }
}