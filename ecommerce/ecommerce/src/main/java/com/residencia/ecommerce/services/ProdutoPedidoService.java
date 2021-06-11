package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.ProdutoPedido;
import com.residencia.ecommerce.repositories.ProdutoPedidoRepository;

@Service
public class ProdutoPedidoService {

    @Autowired
    public ProdutoPedidoRepository produtoPedidoRepository;

    public ProdutoPedido findById(Integer id) {
        return produtoPedidoRepository.findById(id).get();
    }

    public List<ProdutoPedido> findAll() {
        return produtoPedidoRepository.findAll();
    }

    public Long count() {
        return produtoPedidoRepository.count();
    }

    public ProdutoPedido save(ProdutoPedido produtoPedido) {
        ProdutoPedido novoProdutoPedido = produtoPedidoRepository.save(produtoPedido);
        return novoProdutoPedido;
    }

    public ProdutoPedido update(ProdutoPedido produtoPedido) {
        return produtoPedidoRepository.save(produtoPedido);
    }

    public ProdutoPedido update(Integer id, ProdutoPedido produtoPedido) {
        ProdutoPedido novoProdutoPedido = produtoPedidoRepository.findById(id).get();
        updateDados(novoProdutoPedido, produtoPedido);
        return produtoPedidoRepository.save(novoProdutoPedido);
    }

    private void updateDados(ProdutoPedido novoProdutoPedido, ProdutoPedido produtoPedido) {
    	novoProdutoPedido.setProdutoPedidoId(produtoPedido.getProdutoPedidoId());
        novoProdutoPedido.setPedido(produtoPedido.getPedido());
        novoProdutoPedido.setPreco(produtoPedido.getPreco());
        novoProdutoPedido.setProduto(produtoPedido.getProduto());
        novoProdutoPedido.setQuantidade(produtoPedido.getQuantidade());
    }

    public boolean delete(Integer id) {
        if(id != null) {
            produtoPedidoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}