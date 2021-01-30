package com.group36.healthchecker.repository;

import com.group36.healthchecker.model.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
import java.util.List;

public interface UserRepository2 extends JpaRepository<User2, Integer> 
{
    
	
	Optional<User2> findByUserName(String userName);
    
    @Query(value = "SELECT id, user_Name, roles FROM users", nativeQuery = true)
    public List<Object[]> findUsers();
    
   
    
    
}