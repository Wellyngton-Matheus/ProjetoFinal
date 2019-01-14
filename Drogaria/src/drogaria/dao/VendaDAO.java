package drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bibliotecaspring.models.venda;
import bibliotecaspring.models.venda;
import bibliotecaspring.models.venda;


public class VendaDAO {
	private static Connection connection;

	public VendaDAO() {
		connection = ConnectionFactory.getConnection();
	}
	public boolean inserir(Venda venda) {

		String sql = "insert into venda (livro, venda, datavenda, dataDevolucao) values (?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, venda.getLivro().getId());
			stmt.setLong(2, venda.getvenda().getId());			
			Calendar dataEmp = Calendar.getInstance();
			stmt.setDate(3, new java.sql.Date(dataEmp.getTimeInMillis()));
			stmt.setDate(4, null);
			
			stmt.execute();
			stmt.close();
			System.out.println("foi vendido");

		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		return false;
	}
	public boolean qtdVendas(Venda venda) throws SQLException {

		try {
			PreparedStatement stmt = connection
					.prepareStatement("select * from venda where usuario = ? and dataDevolucao IS NULL;");
			stmt.setLong(1, venda.getvenda().getId());
			ResultSet rs = stmt.executeQuery();
			int cont = 0;
			while (rs.next()) {
				cont++;
			}
			stmt.close();
			if (cont > 2) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}
	public List<Venda> getLista() {
		try {

			List<venda> venda = new ArrayList<venda>();
			PreparedStatement stmt = connection.prepareStatement("select * from venda;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				venda.add (criandovenda(rs));
				
			}
			rs.close();
			stmt.close();
			return venda;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
