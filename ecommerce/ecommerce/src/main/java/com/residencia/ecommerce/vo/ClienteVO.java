package com.residencia.ecommerce.vo;

import java.util.Calendar;
import java.util.List;

import com.residencia.ecommerce.entities.Endereco;

public class ClienteVO {

	private Integer clienteId;
	private String email;
	private String username;
	private String senha;
	private String nomeCliente;
	private String cpf;
	private String telefone;
	private Calendar dataNascimento;
	private Endereco endereco;
	private List<PedidoVO> listaPedidoVO;

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

	public List<PedidoVO> getListaPedidoVO() {
		return listaPedidoVO;
	}

	public void setListaPedidoVO(List<PedidoVO> listaPedidoVO) {
		this.listaPedidoVO = listaPedidoVO;
	}

}