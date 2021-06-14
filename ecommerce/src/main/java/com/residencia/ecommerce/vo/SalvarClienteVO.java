package com.residencia.ecommerce.vo;

import java.util.Calendar;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SalvarClienteVO {

	private Integer clienteId;
	
	@NotBlank (message = "O Email não pode ser nulo!")
	private String email;
	
	@NotBlank (message = "O Username não pode ser nulo!")
    @Size(max = 10, message = "O Username não pode ter mais que 10 caracteres!")
	private String username;
	
	@NotBlank (message = "A senha não pode ser nula!")
	private String senha;
	private String telefone;
	private String cep;
	
	@NotBlank (message = "O CPF não pode ser nulo")
	@Size(max = 11, message = "Use somente números!")
	@Size(min = 11, message = "CPF inválido")
	private String cpf;
	private String complemento;
	private Integer numero;
	private String nomeCliente;
	
	@NotNull (message = "Data de nascimento não pode ser nula!")
	private Calendar dataNascimento;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
