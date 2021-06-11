package com.residencia.ecommerce.vo;

import java.math.BigDecimal;
import java.util.Calendar;

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.entities.ProdutoPedido;

public class PedidoVO {

	private Integer pedidoId;
	private Integer numeroPedido;
	private String listaProdutosPedido;
	private BigDecimal valorTotalPedido;
	private Calendar dataPedido;
	private String status;
	private Cliente cliente;
	private ProdutoPedido produtoPedido;

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getListaProdutosPedido() {
		return listaProdutosPedido;
	}

	public void setListaProdutosPedido(String listaProdutosPedido) {
		this.listaProdutosPedido = listaProdutosPedido;
	}

	public BigDecimal getValorTotalPedido() {
		return valorTotalPedido;
	}

	public void setValorTotalPedido(BigDecimal valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ProdutoPedido getProdutoPedido() {
		return produtoPedido;
	}

	public void setProdutoPedido(ProdutoPedido produtoPedido) {
		this.produtoPedido = produtoPedido;
	}

}
