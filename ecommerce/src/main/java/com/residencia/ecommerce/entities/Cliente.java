package com.residencia.ecommerce.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Integer clienteId;
	
	@NotBlank (message = "O Email não pode ser nulo!")
	@Column(name = "email")
	private String email;
	
	@NotBlank (message = "O Username não pode ser nulo!")
    @Size(max = 10, message = "O Username não pode ter mais que 10 caracteres!")
	@Column(name = "username")
	private String username;
	
	@NotBlank (message = "A senha não pode ser nula!")
	@Column(name = "senha")
	private String senha;
	
	@NotBlank (message = "O Nome não pode ser nulo!")
	@Column(name = "nome_cliente")
	private String nomeCliente;
	
	@NotBlank (message = "O CPF não pode ser nulo")
	@Size(max = 11, message = "Use somente números!")
	@Size(min = 11, message = "CPF inválido")
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	
	@NotBlank (message = "O telefone não pode ser nulo")
	@Size(max = 11, message = "Use somente números!")
	@Size(min = 10, message = "Número inválido")
	@Column(name = "telefone")
	private String telefone;
	
	@NotNull (message = "Data de nascimento não pode ser nula!")
	@Column(name = "data_nascimento")
	private Calendar dataNascimento;
	
	@JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
	@ManyToOne
	private Endereco endereco;

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

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
