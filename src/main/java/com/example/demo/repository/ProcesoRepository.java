package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Proceso;

public interface ProcesoRepository extends JpaRepository<Proceso, Long>{

}
