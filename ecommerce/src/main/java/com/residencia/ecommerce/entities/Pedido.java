package com.residencia.ecommerce.entities;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_id")
	private Integer pedidoId;

	@NotNull (message = "Adicione o numero do pedido! ")
	@Column(name = "numero_pedido")
	private Integer numeroPedido;

	@NotNull(message = "Adicione um preço! ")
    @DecimalMin(value = "5", message = "O preço não pode ser menor que R$ {value}.00")
	@Column(name = "valor_total_pedido")
	private BigDecimal valorTotalPedido;
	
	@Column(name = "lista_de_produtos_do_pedido")
	private String listaDeProdutosDoPedido;

	@NotNull(message = "Adicione a data do pedido! ")
	@Column(name = "data_pedido")
	private Calendar dataPedido;

	@NotBlank (message = "Adicione um status do pedido! ")
	@Column(name = "status")
	private String status;

	@NotNull (message = "Adicione o ID do cliente! ")
	@JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
	@ManyToOne
	private Cliente cliente;

	@OneToOne(mappedBy = "pedido")
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

	public String getListaDeProdutosDoPedido() {
		return listaDeProdutosDoPedido;
	}

	public void setListaDeProdutosDoPedido(String listaDeProdutosDoPedido) {
		this.listaDeProdutosDoPedido = listaDeProdutosDoPedido;
	}

}
