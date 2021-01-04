package com.group36.healthchecker.repository;

import com.group36.healthchecker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> 
{
    Optional<User> findByUserName(String userName);
}
