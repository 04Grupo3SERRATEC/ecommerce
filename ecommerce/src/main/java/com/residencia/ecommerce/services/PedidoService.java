package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.repositories.PedidoRepository;

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

    public Pedido update(Integer id, Pedido pedido) {
        Pedido novoPedido = pedidoRepository.findById(id).get();
        updateDados(novoPedido, pedido);
        return pedidoRepository.save(novoPedido);
    }

    private void updateDados(Pedido novoPedido, Pedido pedido) {
        novoPedido.setCliente(pedido.getCliente());
        novoPedido.setDataPedido(pedido.getDataPedido());
        novoPedido.setProdutoPedido(pedido.getProdutoPedido());
        novoPedido.setListaProdutosPedido(pedido.getListaProdutosPedido());
        novoPedido.setNumeroPedido(pedido.getNumeroPedido());
        novoPedido.setStatus(pedido.getListaProdutosPedido());
        novoPedido.setPedidoId(pedido.getPedidoId());
        novoPedido.setValorTotalPedido(pedido.getValorTotalPedido());
    }

    public boolean delete(Integer id) {
        if(id != null) {
            pedidoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}