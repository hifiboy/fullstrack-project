package com.staffscheduling.staffscheduling.Repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.staffscheduling.staffscheduling.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}