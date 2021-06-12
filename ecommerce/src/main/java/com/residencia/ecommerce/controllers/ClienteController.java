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

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.services.ClienteService;
import com.residencia.ecommerce.vo.ClienteVO;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(clienteService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(clienteService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long count() {
		return clienteService.count();
	}

//	@PostMapping
//	public ResponseEntity<ClienteVO> save(@RequestBody ClienteVO clienteVO) {
//		HttpHeaders headers = new HttpHeaders();
//		ClienteVO novoClienteVO = clienteService.save(clienteVO);
//
//		if (null != novoClienteVO)
//			return new ResponseEntity<>(novoClienteVO, headers, HttpStatus.OK);
//		else
//			return new ResponseEntity<>(novoClienteVO, headers, HttpStatus.BAD_REQUEST);
//	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente) {
        HttpHeaders headers = new HttpHeaders();

        if (null != clienteService.save(cliente))
            return new ResponseEntity<>(clienteService.save(cliente), headers, HttpStatus.OK);
        else
            return new ResponseEntity<>(clienteService.save(cliente), headers, HttpStatus.BAD_REQUEST);
    }

	@PutMapping
	public ClienteVO update(@Valid @RequestParam Integer id, @RequestBody ClienteVO clienteVO) {
		return clienteService.update(id, clienteVO);
	}

	@DeleteMapping
	public ResponseEntity<Cliente> delete(@RequestParam Integer id) {
		HttpHeaders headers = new HttpHeaders();
		boolean isRemoved = clienteService.delete(id);
		if (isRemoved) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

}