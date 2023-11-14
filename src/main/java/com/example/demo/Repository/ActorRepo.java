package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Actor;

public interface ActorRepo extends JpaRepository<Actor,Long>{
    
}
