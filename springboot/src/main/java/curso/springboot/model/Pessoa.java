package curso.springboot.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;






@Entity // informa que essa classe é uma entidade tabela de banco de dados 
public class Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // geração automatica de chave primaria na tabela--> campo id 
	private Long id;
	
	@NotNull(message = "nome não pode ser nulo ")
	@NotEmpty(message = "nome não pode ser vazio")
	private String nome;
	
	@NotNull(message = "sobrenome não pode ser nulo ")
	@NotEmpty(message = "sobrenome não pode ser vazio")
	private String sobrenome;
	
	@Min(value=18, message = "idade invalida")
	private int idade;
	
	@OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL)
	
	private List<Telefone> telefones;
	
	public List<Telefone> getTelfones() {
		return telefones;
	}
	public void setTelfones(List<Telefone> telfones) {
		this.telefones = telfones;
	}
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
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	

	

}
