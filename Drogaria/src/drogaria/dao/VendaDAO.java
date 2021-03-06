package drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



import drogaria.models.Cliente;
import drogaria.models.Remedio;
import drogaria.models.Venda;



public class VendaDAO {
	private static Connection connection;

	public VendaDAO() {
		connection = ConnectionFactory.getConnection();
	}
	public boolean inserir(Venda venda) {

		String sql = "insert into venda (cliente, remedio, dataVenda) values (?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, venda.getCliente().getId());
			stmt.setLong(2, venda.getRemedio().getId());						
			Calendar dataVenda = Calendar.getInstance();
			stmt.setDate(3, new java.sql.Date(dataVenda.getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			System.out.println("foi vendido");

		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		return false;
	}

	public List<Venda> getLista() {
		try {

			List<Venda> venda = new ArrayList<Venda>();
			PreparedStatement stmt = connection.prepareStatement("select * from venda;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				venda.add (criandoVenda(rs));
				
			}
			rs.close();
			stmt.close();
			return venda;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public boolean remover(Venda venda) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from venda where id=?;");
			stmt.setLong(1, venda.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private Venda criandoVenda(ResultSet rs) throws SQLException {
		Venda venda = new Venda();

		venda.setId(rs.getLong("id"));
		Cliente cliente = new ClienteDAO().getById(rs.getLong("cliente"));
		venda.setCliente(cliente);
		Remedio remedio = new RemedioDAO().getById(rs.getLong("remedio"));
		venda.setRemedio(remedio);

		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("dataVenda"));
		venda.setDataVenda(data);

		

		return venda;
	}
	public Venda getvendaByID(Long id) {
		try {

			Venda venda = null;
			PreparedStatement stmt = connection.prepareStatement("select * from venda where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				venda = criandoVenda(rs);
			}
			rs.close();
			stmt.close();
			return venda;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}
	public void efetuada(Venda venda) {
		// TODO Auto-generated method stub
		
	}
}
