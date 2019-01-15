package drogaria.models;

import java.util.Calendar;

public class Venda {
	private Long id;
	private Cliente Cliente;
	private Remedio Remedio;
	private Calendar dataVenda;
	
	

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente Cliente) {
		this.Cliente = Cliente;
	}

public Remedio getRemedio() {
	return Remedio;
	}

public void setRemedio(Remedio Remedio) {
	this.Remedio = Remedio;
	}

@Override
public String toString() {
	return "Venda [id=" + id + ", Cliente=" + Cliente + ", Remedio=" + Remedio + ", dataVenda=" + dataVenda + "]";
}
}