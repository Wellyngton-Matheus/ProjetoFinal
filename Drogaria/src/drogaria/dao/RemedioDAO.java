package drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import drogaria.models.Remedio;

public class RemedioDAO {
	private Connection connection;

	public RemedioDAO() {
		connection = ConnectionFactory.getConnection();

	}

	public boolean inserir(Remedio remedio) {
		String sql = "insert into remedio (nome, funcionalidade, preco) values (?, ?, ?);";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, remedio.getNome());
			stmt.setString(2, remedio.getFuncionalidade());
			stmt.setString(3, remedio.getPreco());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Remedio> getLista() {
		List<Remedio> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from remedio;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Remedio remedio = new Remedio();
				remedio.setId(rs.getLong("id"));
				remedio.setNome(rs.getString("nome"));
				remedio.setFuncionalidade(rs.getString("funcionalidade"));
				remedio.setPreco(rs.getString("preco"));

				result.add(remedio);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean remover(Remedio remedio) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from remedio where id=?;");
			stmt.setLong(1, remedio.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Remedio getById(long l) {
		Remedio result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from remedio where id = ?;");
			stmt.setLong(1, l);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				result = new Remedio();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setFuncionalidade(rs.getString("Funcionalidade"));
				result.setPreco(rs.getString("preco"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
