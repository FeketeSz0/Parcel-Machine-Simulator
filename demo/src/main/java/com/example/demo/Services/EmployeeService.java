package com.example.demo.Services;

import com.example.demo.Repositories.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService implements UserDetailsService {

    private final EmployeeRepo employeeRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeRepo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("username not found"));
    }
}
