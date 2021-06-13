package com.residencia.ecommerce.controllers;

import java.util.List;

import javax.mail.MessagingException;
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

import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.exceptions.EmailException;
import com.residencia.ecommerce.services.EmailService;
import com.residencia.ecommerce.services.PedidoService;
import com.residencia.ecommerce.vo.FinalizarPedidoVO;
import com.residencia.ecommerce.vo.PedidoVO;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    
    @Autowired
	public EmailService emailService;

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(pedidoService.findById(id), headers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(pedidoService.findAll(), headers, HttpStatus.OK);
    }

    @GetMapping("/count")
    public Long count() {
        return pedidoService.count();
    }

    
    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) throws MessagingException, EmailException {
        HttpHeaders headers = new HttpHeaders();

        Integer id = pedido.getPedidoId(); 
        PedidoVO novoPedidoVO = new PedidoVO();
        
        pedidoService.emitirPedido(id);
        emailService.emailPedidoFinalizado(novoPedidoVO);	
        
        if (null != pedidoService.save(pedido))
            return new ResponseEntity<>(pedidoService.save(pedido), headers, HttpStatus.OK);
        else
            return new ResponseEntity<>(pedidoService.save(pedido), headers, HttpStatus.BAD_REQUEST);
    }
    
    

    @PutMapping
    public ResponseEntity<Pedido> update(@Valid @RequestParam Integer id, @RequestBody Pedido pedido) {
    	HttpHeaders headers = new HttpHeaders();
    	if (pedidoService.update(id, pedido)) {
    		return new ResponseEntity<>(headers, HttpStatus.LOCKED);
    	}
        else
            return new ResponseEntity<>(headers, HttpStatus.OK);
    }
    
    @PutMapping("/finalizarPedido")
    public ResponseEntity<FinalizarPedidoVO> finalizarPedido(@Valid @RequestParam Integer id, @RequestBody FinalizarPedidoVO finalizarPedidoVO) {
    	HttpHeaders headers = new HttpHeaders();
    	if (pedidoService.finalizarPedidoVO(id, finalizarPedidoVO))
    		return new ResponseEntity<>(headers, HttpStatus.OK);
        else
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    public ResponseEntity<Pedido> delete(@RequestParam Integer id){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = pedidoService.delete(id);
        if(isRemoved) {
            return new ResponseEntity<>(headers, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

}