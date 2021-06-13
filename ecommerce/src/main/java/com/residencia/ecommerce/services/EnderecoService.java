package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Endereco;
import com.residencia.ecommerce.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	public EnderecoRepository enderecoRepository;

	public Endereco findById(Integer id) {
		return enderecoRepository.findById(id).get();
	}

	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	public Long count() {
		return enderecoRepository.count();
	}

	public Endereco save(Endereco endereco) {
		Endereco novoEndereco = enderecoRepository.save(endereco);
		return novoEndereco;
	}

	public Endereco update(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Endereco update(Integer id, Endereco endereco) {
		Endereco novoEndereco = enderecoRepository.findById(id).get();
		updateDados(novoEndereco, endereco);
		return enderecoRepository.save(novoEndereco);
	}

	private void updateDados(Endereco novoEndereco, Endereco endereco) {
		novoEndereco.setBairro(endereco.getBairro());
		novoEndereco.setCep(endereco.getCep());
		novoEndereco.setLocalidade(endereco.getLocalidade());
		novoEndereco.setCliente(endereco.getCliente());
		novoEndereco.setComplemento(endereco.getComplemento());
		novoEndereco.setEnderecoId(endereco.getEnderecoId());
		novoEndereco.setUf(endereco.getUf());
		novoEndereco.setNumero(endereco.getNumero());
		novoEndereco.setLogradouro(endereco.getLogradouro());
	}

	public boolean delete(Integer id) {
		if (id != null) {
			enderecoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

//	public CepVO consultarEnderecoCep(String cep, Cliente cliente) {
//		RestTemplate restTemplate = new RestTemplate();
//		String uri = "https://viacep.com.br/ws/{cep}/json/";
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("cep", cep);
//		CepVO cepVO = restTemplate.getForObject(uri, CepVO.class, params);
//		
//
//		return cepVO;
//	}
}