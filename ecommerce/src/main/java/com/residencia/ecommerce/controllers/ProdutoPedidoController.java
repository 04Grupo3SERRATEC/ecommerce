package com.residencia.ecommerce.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.residencia.ecommerce.entities.ProdutoPedido;
import com.residencia.ecommerce.services.ProdutoPedidoService;

@RestController
@RequestMapping("/produtoPedido")
public class ProdutoPedidoController {

    @Autowired
    private ProdutoPedidoService produtoPedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoPedido> findById(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(produtoPedidoService.findById(id), headers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoPedido>> findAll() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(produtoPedidoService.findAll(), headers, HttpStatus.OK);
    }

    @GetMapping("/count")
    public Long count() {
        return produtoPedidoService.count();
    }

    @PostMapping
    public ResponseEntity<ProdutoPedido> save(@RequestBody ProdutoPedido produtoPedido) {
        HttpHeaders headers = new HttpHeaders();

        if (null != produtoPedidoService.save(produtoPedido))
            return new ResponseEntity<>(produtoPedidoService.save(produtoPedido), headers, HttpStatus.OK);
        else
            return new ResponseEntity<>(produtoPedidoService.save(produtoPedido), headers, HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ProdutoPedido update(@RequestBody Integer id, ProdutoPedido produtoPedido) {
        return produtoPedidoService.update(id, produtoPedido);
    }

    @DeleteMapping
    public ResponseEntity<ProdutoPedido> delete(@RequestParam Integer id){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = produtoPedidoService.delete(id);
        if(isRemoved) {
            return new ResponseEntity<>(headers, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

}