package curso.springboot.model;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;




@SuppressWarnings("deprecation")
@Entity  // informa que essa classe é uma entidade tabela de banco de dados
public class Telefone {
	
	/**
	 * 
	 */ 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // geração automatica de chave primaria na tabela--> campo id .
	private Long id;
	
	private String numero;
	private String tipo;
	
	@ForeignKey(name="pessoa.id")
	@ManyToOne
	private Pessoa pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
