package com.residencia.ecommerce.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;import javax.persistence.Table;

@Entity
@Table(name = "produto_pedido")
public class ProdutoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_pedido_id")
    private Integer produtoPedidoId;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "preco")
    private BigDecimal preco;
    
    @JoinColumn(name = "produto_id", referencedColumnName = "produto_id")
    @OneToOne 
    private Produto produto;
    
    @JoinColumn(name = "pedido_id", referencedColumnName = "pedido_id")
    @OneToOne
    private Pedido pedido;

	public Integer getProdutoPedidoId() {
		return produtoPedidoId;
	}

	public void setProdutoPedidoId(Integer produtoPedidoId) {
		this.produtoPedidoId = produtoPedidoId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}