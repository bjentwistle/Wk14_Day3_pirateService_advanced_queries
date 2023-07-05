package com.example.codeclan.pirateservice.repository;

import com.example.codeclan.pirateservice.models.Signup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpRepository extends JpaRepository<Signup, Long> {
}
