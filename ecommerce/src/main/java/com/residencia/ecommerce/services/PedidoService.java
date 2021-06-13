package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.entities.ProdutoPedido;
import com.residencia.ecommerce.repositories.PedidoRepository;
import com.residencia.ecommerce.vo.FinalizarPedidoVO;
import com.residencia.ecommerce.vo.PedidoVO;

@Service
public class PedidoService {

    @Autowired
    public PedidoRepository pedidoRepository;

    public Pedido findById(Integer id) {
        return pedidoRepository.findById(id).get();
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Long count() {
        return pedidoRepository.count();
    }

    public Pedido save(Pedido pedido) {
        Pedido novoPedido = pedidoRepository.save(pedido);
        return novoPedido;
    }

    public Pedido update(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public boolean update(Integer id, Pedido pedido) {
    	Pedido pedido2 = new Pedido();
    	pedido2 = pedidoRepository.findById(id).get();
        if(pedido2.getStatus().equalsIgnoreCase("finalizado")) {
        	return true;
        } else {
        	updateNaoFinalizado(id, pedido);
        	return false;
        }
    }
    
    public boolean finalizarPedidoVO(Integer id, FinalizarPedidoVO finalizarPedidoVO) {
    	Pedido pedido2 = new Pedido();
    	pedido2 = pedidoRepository.findById(id).get();
        if(pedido2.getStatus().equalsIgnoreCase("finalizado")) {
        	return false;
        } else {
        	updateFinalizado(id, finalizarPedidoVO);
        	return true;
        }
    }
    
    public Pedido updateNaoFinalizado(Integer id, Pedido pedido) {
        Pedido novoPedido = pedidoRepository.findById(id).get();
        updateDados(novoPedido, pedido);
        return pedidoRepository.save(novoPedido);
    }

    private void updateDados(Pedido novoPedido, Pedido pedido) {
        novoPedido.setCliente(pedido.getCliente());
        novoPedido.setDataPedido(pedido.getDataPedido());
        novoPedido.setProdutoPedido(pedido.getProdutoPedido());
        novoPedido.setNumeroPedido(pedido.getNumeroPedido());
        novoPedido.setStatus(pedido.getStatus());
        novoPedido.setPedidoId(pedido.getPedidoId());
        novoPedido.setValorTotalPedido(pedido.getValorTotalPedido());
    }
    
    private void updateFinalizado(Integer id, FinalizarPedidoVO finalizarPedidoVO) {
    	Pedido pedido = new Pedido();
    	pedido = pedidoRepository.findById(id).get();
        pedido.setStatus(finalizarPedidoVO.getStatus());
        pedidoRepository.save(pedido);
    }

    public boolean delete(Integer id) {
        if(id != null) {
            pedidoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
    public PedidoVO emitirPedido(Integer pedidoId) {
  		Pedido pedido =  pedidoRepository.getById(pedidoId);
  		
  		PedidoVO pedidoVO = new PedidoVO();
  		ProdutoPedido ppVO = new ProdutoPedido();
  		Produto p = new Produto();
  		
  		pedidoVO.setPedidoId(pedido.getPedidoId());
  		pedidoVO.setDataPedido(pedido.getDataPedido());
  		pedidoVO.setValorTotalPedido(pedido.getValorTotalPedido());
  		ppVO.setQuantidade(ppVO.getQuantidade());
  		p.setNomeProduto(p.getNomeProduto());
  		
  		return pedidoVO;
  	}

}