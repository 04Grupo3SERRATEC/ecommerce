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
import org.springframework.web.bind.annotation.RestController;

import com.residencia.ecommerce.entities.Endereco;
import com.residencia.ecommerce.services.EnderecoService;
import com.residencia.ecommerce.vo.CepVO;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(enderecoService.findById(id), headers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(enderecoService.findAll(), headers, HttpStatus.OK);
    }

    @GetMapping("/count")
    public Long count() {
        return enderecoService.count();
    }

    @PostMapping
    public ResponseEntity<Endereco> save(@RequestBody Endereco endereco) {
        HttpHeaders headers = new HttpHeaders();

        if (null != enderecoService.save(endereco))
            return new ResponseEntity<>(enderecoService.save(endereco), headers, HttpStatus.OK);
        else
            return new ResponseEntity<>(enderecoService.save(endereco), headers, HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public Endereco update(@Valid @RequestParam Integer id, @RequestBody Endereco endereco) {
        return enderecoService.update(id, endereco);
    }

    @DeleteMapping
    public ResponseEntity<Endereco> delete(@RequestParam Integer id){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = enderecoService.delete(id);
        if(isRemoved) {
            return new ResponseEntity<>(headers, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/consutarcep/{cep}")
    public ResponseEntity<CepVO> consultarCep(@PathVariable String cep) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(enderecoService.consultarEndereçoCep(cep), headers, HttpStatus.OK);
    }

}
