package com.Smart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Smart.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

}
