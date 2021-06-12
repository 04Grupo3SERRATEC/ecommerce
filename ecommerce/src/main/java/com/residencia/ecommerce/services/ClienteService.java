package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.repositories.ClienteRepository;
import com.residencia.ecommerce.repositories.PedidoRepository;
import com.residencia.ecommerce.vo.ClienteVO;

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

//	public ClienteVO save(ClienteVO clienteVO) {
//		Cliente cliente = converteVOParaEntidade(clienteVO, null);
//		cliente = clienteRepository.save(cliente);
//		
//		return converteEntidadeParaVO(cliente);
//	}
	
	public Cliente save(Cliente cliente) {
		Cliente novoCliente = clienteRepository.save(cliente);
		return novoCliente;
	}

	public Cliente update(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public ClienteVO update(Integer id, ClienteVO clienteVO) {
		Cliente cliente2 = clienteRepository.findById(id).get();
		Cliente cliente = converteVOParaEntidade(clienteVO, id);
		cliente.setClienteId(cliente2.getClienteId());
		cliente.setNomeCliente(cliente2.getNomeCliente());
		cliente.setDataNascimento(cliente2.getDataNascimento());
		cliente.setCpf(cliente2.getCpf());
		Cliente novoCliente = clienteRepository.save(cliente);
		return converteEntidadeParaVO(novoCliente);
	}

//	private void updateDados(Cliente novoCliente, Cliente cliente) {
//		novoCliente.setClienteId(cliente.getClienteId());
//		novoCliente.setClienteId(cliente.getClienteId());
//		novoCliente.setDataNascimento(cliente.getDataNascimento());
//		novoCliente.setEmail(cliente.getEmail());
//		novoCliente.setEndereco(cliente.getEndereco());
//		novoCliente.setNomeCliente(cliente.getNomeCliente());
//		novoCliente.setSenha(cliente.getSenha());
//		novoCliente.setTelefone(cliente.getTelefone());
//		novoCliente.setUsername(cliente.getUsername());
//	}

	private ClienteVO converteEntidadeParaVO(Cliente cliente) {
		ClienteVO clienteVO = new ClienteVO();

		clienteVO.setClienteId(cliente.getClienteId());
		clienteVO.setEmail(cliente.getEmail());
		clienteVO.setEndereco(cliente.getEndereco());
		clienteVO.setSenha(cliente.getSenha());
		clienteVO.setTelefone(cliente.getTelefone());
		clienteVO.setUsername(cliente.getUsername());
		
		return clienteVO;
	}

	private Cliente converteVOParaEntidade(ClienteVO clienteVO, Integer id) {
		Cliente cliente = new Cliente();

		cliente.setClienteId(clienteVO.getClienteId());
		cliente.setEmail(clienteVO.getEmail());
		cliente.setEndereco(clienteVO.getEndereco());
		cliente.setSenha(clienteVO.getSenha());
		cliente.setTelefone(clienteVO.getTelefone());
		cliente.setUsername(clienteVO.getUsername());
		
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
