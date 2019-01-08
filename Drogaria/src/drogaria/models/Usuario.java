package drogaria.models;

public class Usuario {
	private Long id;
	private String nome;
	private String senha;
	private String cpf;
	private String email;
	private String numero;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
		public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setNome(String l) {
		this.nome = l;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", senha=" + senha + ", cpf=" + cpf + ", email=" + email + ", numero=" + numero
				+ "]";
	}

}
