package com.example.demo.Repositories;

import com.example.demo.modells.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Long> {

    Optional<Employees> findByUsername(String username);
}
