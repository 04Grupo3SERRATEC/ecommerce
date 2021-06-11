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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produto_id")
	private Integer produtoId;

	@Column(name = "nome_produto")
	private String nomeProduto;
	
	@NotBlank (message = "Preencha a descrição")
	@Size(max = 40, message = "numero maximo de caracteres 40")
	@Column(name = "descricao_produto", nullable = false, length = 40)
	private String descricaoProduto;

	@DecimalMax(value = "5000", message = "O preço não pode ser maior que R${value}.00")
	@DecimalMin(value = "5", message = "O preço não pode ser menor que R${value}.00")
	@Column(name = "preco_produto")
	private BigDecimal precoProduto;

	@Column(name = "qtd_estoque")
	private Integer qtdEstoque;

	@Column(name = "data_cadastro_produto")
	@Temporal(TemporalType.DATE)
	private Calendar dataCadastroProduto;

	@JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
	@ManyToOne
	private Categoria categoria;

	@OneToOne(mappedBy = "produto")
	private ProdutoPedido produtoPedido;

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public BigDecimal getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(BigDecimal precoProduto) {
		this.precoProduto = precoProduto;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Calendar getDataCadastroProduto() {
		return dataCadastroProduto;
	}

	public void setDataCadastroProduto(Calendar dataCadastroProduto) {
		this.dataCadastroProduto = dataCadastroProduto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ProdutoPedido getProdutoPedido() {
		return produtoPedido;
	}

	public void setProdutoPedido(ProdutoPedido produtoPedido) {
		this.produtoPedido = produtoPedido;
	}

}
