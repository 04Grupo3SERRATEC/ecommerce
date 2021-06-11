package com.residencia.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.ecommerce.entities.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}