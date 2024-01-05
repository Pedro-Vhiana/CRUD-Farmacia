package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "É obrigatório inserir uma Categoria")
	@Size(min = 3, max = 50, message = "A categoria deve conter no mínimo 3 e no máximo 50 caracteres")
	@Column(length = 50)
	private String categoria;
	
	@NotBlank (message = "É obrigatório inserir uma descrição")
	@Size(min = 10, max = 150, message = "A descrição deve conter no mínimo 10 e no máximo 150 caracteres")
	@Column(length = 150)
	private String descricao;


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}