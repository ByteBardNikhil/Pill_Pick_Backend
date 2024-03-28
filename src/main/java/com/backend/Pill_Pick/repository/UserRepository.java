package com.backend.Pill_Pick.repository;

import com.backend.Pill_Pick.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
