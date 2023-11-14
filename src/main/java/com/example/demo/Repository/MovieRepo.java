package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Movie;

public interface MovieRepo extends JpaRepository<Movie,Long>{
    
}
