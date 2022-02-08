package com.Smart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Smart.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer>
{

}
