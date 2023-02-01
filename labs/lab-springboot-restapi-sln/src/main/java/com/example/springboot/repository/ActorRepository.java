package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sprinboot.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

}
