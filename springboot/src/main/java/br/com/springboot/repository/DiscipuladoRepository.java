package br.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.models.Discipulado;


public interface DiscipuladoRepository extends JpaRepository<Discipulado,Long>{
    
}
