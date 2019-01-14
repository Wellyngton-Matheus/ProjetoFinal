package drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import drogaria.models.Cliente;



public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Cliente cliente) {

		String sql = "insert into cliente (nome, senha, cpf, email, numero) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getSenha());
			stmt.setString(3, cliente.getCpf());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getNumero());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean existeCliente(Cliente cliente) {

		String sql = "select * from cliente where cliente= ?  and senha= ?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getSenha());

			ResultSet rs = stmt.executeQuery();

			stmt.execute();

			// verifica se existe retorno na consulta
			if (rs.next()) {
				stmt.close();
				return true;
			} else {
				stmt.close();
				return false;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Cliente> getLista() {
		List<Cliente> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from cliente;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setNumero(rs.getString("numero"));

				result.add(cliente);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Cliente cliente) {
		String sql = "update cliente set nome=?, senha=?, cpf=?, email=?, numero=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getSenha());
			stmt.setString(3, cliente.getCpf());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getNumero());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Cliente cliente) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from cliente where id=?;");
			stmt.setLong(1, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Cliente getById(long l) {
		Cliente result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from cliente where id = ?;");
			stmt.setInt(1, (int) l);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Contato

				result = new Cliente();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setCpf(rs.getString("cpf"));
				result.setEmail(rs.getString("email"));
				result.setNumero(rs.getString("numero"));

			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
