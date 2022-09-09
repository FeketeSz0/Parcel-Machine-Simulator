package com.example.demo.modells;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@NoArgsConstructor
public class Employees implements UserDetails {
    @javax.persistence.Id
    @SequenceGenerator(
            name = "employeesSeq",
            sequenceName = "employeesSeq",
            allocationSize = 1)
    @GeneratedValue(
            generator = "employeesSeq",
            strategy = GenerationType.SEQUENCE)
    private Long Id;
    private String username;
    private String password;
    private boolean active = true;
    @Enumerated(EnumType.STRING)
    private ROLE ROLE;



    public Employees(String username, String password, ROLE ROLE) {
        this.username = username;
        this.password = password;
        this.ROLE = ROLE;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(ROLE.name());
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return active;
    }
}
