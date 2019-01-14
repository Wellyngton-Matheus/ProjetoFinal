package drogaria.models;

public class Remedio {
	private Long id;
	private String nome;
	private String funcionalidade;
	private String preco;
	private Boolean generico;

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

	public String getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(String funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public String getpreco() {
		return preco;
	}

	public void setpreco(String preco) {
		this.preco = preco;
	}

	public Boolean isGenerico() {
		return generico;
	}

	public void setGenerico(Boolean generico) {
		this.generico = generico;
	}

}
