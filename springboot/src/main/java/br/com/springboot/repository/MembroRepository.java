package br.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.models.Membro;


public interface MembroRepository extends JpaRepository<Membro,Long>{
    
}
