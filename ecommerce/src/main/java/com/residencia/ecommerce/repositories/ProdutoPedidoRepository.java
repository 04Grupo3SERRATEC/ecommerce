package com.residencia.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.ecommerce.entities.ProdutoPedido;

@Repository
public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido, Integer>{

}