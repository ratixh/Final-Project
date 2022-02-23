package com.smart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.Entities.User;



public interface UserRepository extends JpaRepository<User, Integer>
{
	@Query()
    public User getUserByUserName(@Param("email") String email);

}
