package com.residencia.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.repositories.ClienteRepository;
import com.residencia.ecommerce.repositories.PedidoRepository;
import com.residencia.ecommerce.vo.ClienteVO;
import com.residencia.ecommerce.vo.PedidoVO;

@Service
public class ClienteService {

	@Autowired
	public ClienteRepository clienteRepository;
	
	@Autowired
	public PedidoRepository pedidoRepository;

	public Cliente findById(Integer id) {
		return clienteRepository.findById(id).get();
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Long count() {
		return clienteRepository.count();
	}

	public ClienteVO save(ClienteVO clienteVO) {
		Cliente novoCliente = converteVOParaEntidade(clienteVO, null);
		Cliente cliente = clienteRepository.save(novoCliente);
		for (Pedido pedido : novoCliente.getListaPedido()) {
			pedido.setCliente(cliente);
			pedidoRepository.save(pedido);
		}
		return converteEntidadeParaVO(novoCliente);
	}

	public Cliente update(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente update(Integer id, Cliente cliente) {
		Cliente novoCliente = clienteRepository.findById(id).get();
		updateDados(novoCliente, cliente);
		return clienteRepository.save(novoCliente);
	}

	private void updateDados(Cliente novoCliente, Cliente cliente) {
		novoCliente.setClienteId(cliente.getClienteId());
		novoCliente.setClienteId(cliente.getClienteId());
		novoCliente.setDataNascimento(cliente.getDataNascimento());
		novoCliente.setEmail(cliente.getEmail());
		novoCliente.setEndereco(cliente.getEndereco());
		novoCliente.setListaPedido(cliente.getListaPedido());
		novoCliente.setNomeCliente(cliente.getNomeCliente());
		novoCliente.setSenha(cliente.getSenha());
		novoCliente.setTelefone(cliente.getTelefone());
		novoCliente.setUsername(cliente.getUsername());
	}

	private ClienteVO converteEntidadeParaVO(Cliente cliente) {
		ClienteVO clienteVO = new ClienteVO();
		List<PedidoVO> listPedidoVO = new ArrayList<>();

		clienteVO.setClienteId(cliente.getClienteId());
		clienteVO.setCpf(cliente.getCpf());
		clienteVO.setClienteId(cliente.getClienteId());
		clienteVO.setDataNascimento(cliente.getDataNascimento());
		clienteVO.setEmail(cliente.getEmail());
		clienteVO.setEndereco(cliente.getEndereco());
		clienteVO.setNomeCliente(cliente.getNomeCliente());
		clienteVO.setSenha(cliente.getSenha());
		clienteVO.setTelefone(cliente.getTelefone());
		clienteVO.setUsername(cliente.getUsername());
		for (Pedido pedido : cliente.getListaPedido()) {
			PedidoVO pedidoVO = new PedidoVO();
			pedidoVO.setCliente(pedido.getCliente());
			pedidoVO.setDataPedido(pedido.getDataPedido());
			pedidoVO.setListaProdutosPedido(pedido.getListaProdutosPedido());
			pedidoVO.setNumeroPedido(pedido.getNumeroPedido());
			pedidoVO.setProdutoPedido(pedido.getProdutoPedido());
			pedidoVO.setStatus(pedido.getStatus());
			pedidoVO.setValorTotalPedido(pedido.getValorTotalPedido());
			listPedidoVO.add(pedidoVO);
		}
		clienteVO.setListaPedidoVO(listPedidoVO);
		return clienteVO;
	}

	private Cliente converteVOParaEntidade(ClienteVO clienteVO, Integer id) {
		Cliente cliente = new Cliente();
		List<Pedido> listPedido = new ArrayList<>();

		cliente.setClienteId(clienteVO.getClienteId());
		cliente.setCpf(clienteVO.getCpf());
		cliente.setDataNascimento(clienteVO.getDataNascimento());
		cliente.setEmail(clienteVO.getEmail());
		cliente.setEndereco(clienteVO.getEndereco());
		cliente.setNomeCliente(clienteVO.getNomeCliente());
		cliente.setSenha(clienteVO.getSenha());
		cliente.setTelefone(clienteVO.getTelefone());
		cliente.setUsername(clienteVO.getUsername());
		if (clienteVO.getListaPedidoVO() != null) {
			for (PedidoVO pedidoVO : clienteVO.getListaPedidoVO()) {
				Pedido pedido = new Pedido();
				pedido.setCliente(pedidoVO.getCliente());
				pedido.setDataPedido(pedidoVO.getDataPedido());
				pedido.setNumeroPedido(pedidoVO.getNumeroPedido());
				pedido.setPedidoId(pedidoVO.getPedidoId());
				pedido.setProdutoPedido(pedidoVO.getProdutoPedido());
				pedido.setStatus(pedidoVO.getStatus());
				pedido.setValorTotalPedido(pedidoVO.getValorTotalPedido());

				listPedido.add(pedido);
			}
		}
		cliente.setListaPedido(listPedido);
		return cliente;
	}

	public boolean delete(Integer id) {
		if (id != null) {
			clienteRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
