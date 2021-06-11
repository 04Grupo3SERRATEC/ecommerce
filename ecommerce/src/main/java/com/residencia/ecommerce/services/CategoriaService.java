package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    public CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id).get();
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Long count() {
        return categoriaRepository.count();
    }

    public Categoria save(Categoria categoria) {
        Categoria novoCategoria = categoriaRepository.save(categoria);
        return novoCategoria;
    }

    public Categoria update(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Integer id, Categoria categoria) {
        Categoria novoCategoria = categoriaRepository.findById(id).get();
        updateDados(novoCategoria, categoria);
        return categoriaRepository.save(novoCategoria);
    }

    private void updateDados(Categoria novoCategoria, Categoria categoria) {
        novoCategoria.setCategoriaId(categoria.getCategoriaId());
        novoCategoria.setDescricaoCategoria(categoria.getDescricaoCategoria());
        novoCategoria.setListaProduto(categoria.getListaProduto());
        novoCategoria.setNomeCategoria(categoria.getNomeCategoria());
    }

    public boolean delete(Integer id) {
        if(id != null) {
            categoriaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}