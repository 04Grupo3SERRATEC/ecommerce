package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    public ProdutoRepository produtoRepository;

    public Produto findById(Integer id) {
        return produtoRepository.findById(id).get();
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Long count() {
        return produtoRepository.count();
    }

    public Produto save(Produto produto) {
        Produto novoProduto = produtoRepository.save(produto);
        return novoProduto;
    }

    public Produto update(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto update(Integer id, Produto produto) {
        Produto novoProduto = produtoRepository.findById(id).get();
        updateDados(novoProduto, produto);
        return produtoRepository.save(novoProduto);
    }

    private void updateDados(Produto novoProduto, Produto produto) {
        novoProduto.setCategoria(produto.getCategoria());
        novoProduto.setDataCadastroProduto(produto.getDataCadastroProduto());
        novoProduto.setDescricaoProduto(produto.getDescricaoProduto());
        novoProduto.setProdutoPedido(produto.getProdutoPedido());
        novoProduto.setNomeProduto(produto.getNomeProduto());
        novoProduto.setPrecoProduto(produto.getPrecoProduto());
        novoProduto.setProdutoId(produto.getProdutoId());
        novoProduto.setQtdEstoque(produto.getQtdEstoque());
    }

    public boolean delete(Integer id) {
        if(id != null) {
            produtoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}