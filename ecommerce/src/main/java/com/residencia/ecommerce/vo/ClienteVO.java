package com.residencia.ecommerce.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClienteVO {

	private Integer clienteId;
	
	@NotBlank (message = "O Email não pode ser nulo!")
	private String email;
	
	@NotBlank (message = "O Username não pode ser nulo!")
    @Size(max = 10, message = "O Username não pode ter mais que 10 caracteres!")
	private String username;
	
	@NotBlank (message = "A senha não pode ser nula!")
	private String senha;
	private String telefone;
	
	@NotBlank (message = "O CEP não pode ser nulo!")
	private String cep;

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}