package com.residencia.ecommerce.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.services.CategoriaService;
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
    	 HttpHeaders headers = new HttpHeaders();
         return new ResponseEntity<>(categoriaService.findById(id), headers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(categoriaService.findAll(), headers, HttpStatus.OK);
    }

    @GetMapping("/count")
    public Long count() {
        return categoriaService.count();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Categoria> save(@Valid @RequestBody Categoria categoria) {
        HttpHeaders headers = new HttpHeaders();

        if (null != categoriaService.save(categoria))
            return new ResponseEntity<>(categoriaService.save(categoria), headers, HttpStatus.OK);
        else
            return new ResponseEntity<>(categoriaService.save(categoria), headers, HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public Categoria update(@Valid @RequestBody Integer id, Categoria categoria) {
        return categoriaService.update(id, categoria);
    }

    @DeleteMapping
    public ResponseEntity<Categoria> delete(@RequestParam Integer id){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = categoriaService.delete(id);
        if(isRemoved) {
            return new ResponseEntity<>(headers, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

}