package com.residencia.ecommerce.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.entities.Endereco;
import com.residencia.ecommerce.repositories.ClienteRepository;
import com.residencia.ecommerce.repositories.EnderecoRepository;
import com.residencia.ecommerce.repositories.PedidoRepository;
import com.residencia.ecommerce.vo.CepVO;
import com.residencia.ecommerce.vo.ClienteVO;
import com.residencia.ecommerce.vo.SalvarClienteVO;

@Service
public class ClienteService {

	@Autowired
	public ClienteRepository clienteRepository;
	
	@Autowired
	public PedidoRepository pedidoRepository;
	
	@Autowired
	public EnderecoRepository enderecoRepository;

	public Cliente findById(Integer id) {
		return clienteRepository.findById(id).get();
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Long count() {
		return clienteRepository.count();
	}

	public SalvarClienteVO save(SalvarClienteVO salvarClienteVO) {
		Cliente cliente = converteSalvarVOParaEntidade(salvarClienteVO, null);
		CepVO cepVO = consultarEnderecoCep(salvarClienteVO.getCep());
		Endereco endereco = new Endereco();
		endereco.setBairro(cepVO.getBairro());
		endereco.setCep(cepVO.getCep());
		endereco.setComplemento(salvarClienteVO.getComplemento());
		endereco.setLocalidade(cepVO.getLocalidade());
		endereco.setLogradouro(cepVO.getLogradouro());
		endereco.setUf(cepVO.getUf());
		endereco.setNumero(salvarClienteVO.getNumero());
		enderecoRepository.save(endereco);
		cliente.setEndereco(endereco);
		cliente = clienteRepository.save(cliente);
		
		return converteEntidadeParaSalvarVO(cliente);
	}
	
//	public Cliente save(Cliente cliente) {
//		Cliente novoCliente = clienteRepository.save(cliente);
//		return novoCliente;
//	}

//	public Cliente update(Cliente cliente) {
//		return clienteRepository.save(cliente);
//	}

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
		clienteVO.setSenha(cliente.getSenha());
		clienteVO.setTelefone(cliente.getTelefone());
		clienteVO.setUsername(cliente.getUsername());
		
		return clienteVO;
	}

	private Cliente converteVOParaEntidade(ClienteVO clienteVO, Integer id) {
		Cliente cliente = new Cliente();
		
		cliente.setClienteId(clienteVO.getClienteId());
		cliente.setEmail(clienteVO.getEmail());
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
	
	private SalvarClienteVO converteEntidadeParaSalvarVO(Cliente cliente) {
		SalvarClienteVO salvarClienteVO = new SalvarClienteVO();
		
		salvarClienteVO.setNomeCliente(cliente.getNomeCliente());
		salvarClienteVO.setClienteId(cliente.getClienteId());
		salvarClienteVO.setEmail(cliente.getEmail());
		salvarClienteVO.setSenha(cliente.getSenha());
		salvarClienteVO.setTelefone(cliente.getTelefone());
		salvarClienteVO.setUsername(cliente.getUsername());
		salvarClienteVO.setCpf(cliente.getCpf());
		salvarClienteVO.setDataNascimento(cliente.getDataNascimento());
		
		return salvarClienteVO;
	}

	private Cliente converteSalvarVOParaEntidade(SalvarClienteVO salvarClienteVO, Integer id) {
		Cliente cliente = new Cliente();
		
		cliente.setDataNascimento(salvarClienteVO.getDataNascimento());
		cliente.setCpf(salvarClienteVO.getCpf());
		cliente.setNomeCliente(salvarClienteVO.getNomeCliente());
		cliente.setClienteId(salvarClienteVO.getClienteId());
		cliente.setEmail(salvarClienteVO.getEmail());
		cliente.setSenha(salvarClienteVO.getSenha());
		cliente.setTelefone(salvarClienteVO.getTelefone());
		cliente.setUsername(salvarClienteVO.getUsername());
		
		return cliente;
	}
	
	public CepVO consultarEnderecoCep(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://viacep.com.br/ws/{cep}/json/";
		Map<String, String> params = new HashMap<String, String>();
		params.put("cep", cep);
		CepVO cepVO = restTemplate.getForObject(uri, CepVO.class, params);
		

		return cepVO;
	}

}
