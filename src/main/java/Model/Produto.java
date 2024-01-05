package Model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do produto é obrigatório.")
	@Size(min = 5, max = 50, message = "O nome do produto deve conter entre 5 e 50 caracteres.")
	@Column(length = 50)
	private String nome;
	
	@NotBlank(message = "A descrição do produto é obrigatória.")
	@Size(min = 10, max = 1000, message = "A descrição está muito pequena...")
	@Column(length = 1000)
	private String descricao;

	
	@NotNull(message = "O valor do produto é obrigatório.")
	@Column(precision = 8, scale = 2) //= DECIMAL(8,2)
	private BigDecimal valor;
	
	@PositiveOrZero(message = "A quantidade precisa ser positiva")
	private Long quantidade = 0L;
	
	@NotBlank(message = "A foto do produto é obrigatória.")
	@Size(min = 50, max = 400, message = "A url é inválida.")
	@Column(length = 400)
	private String foto;
	
	@ManyToOne
	@JsonIgnoreProperties("categoria")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}