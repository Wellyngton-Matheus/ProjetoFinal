package drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import drogaria.models.Remedio;

public class RemedioDAO {
	private Connection connection;

	public RemedioDAO() {
		connection = ConnectionFactory.getConnection();

	}

	public void adiciona(Remedio remedio) {
		String sql = "insert into remedio (id) " + "values (?)";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, remedio.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Remedio> lista(){
		try{
			List<Remedio> Remedios = new ArrayList<Remedio>();
			PreparedStatement stmt = this.connection.prepareStatement
			("select * from Remedios");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto Remedio
				Remedio Remedio = new Remedio();
				Remedio.setId(rs.getLong("id"));
				Remedio.setNome(rs.getString("nome"));
				Remedio.setFuncionalidade(rs.getString("funcionalidade"));
				
				/*if(rs.getDate("dataFinalizacao") != null)
				{
				montando data atraves do calendar
				Calendar dataFinalizacao = Calendar.getInstance();
				dataFinalizacao.setTime(rs.getDate("dataFinalizacao"));
				
				Remedio.setDataFinalizacao(dataFinalizacao);
				}
				adicionar objeto a lista*/
				Remedios.add(Remedio);
			
			rs.close();
			stmt.close();
			System.out.println("Lista gerada coim Sucesso!");
			return Remedios;
	
			}catch(SQLException e){
				e.printStackTrace();
		}
			
			return result;
		}
		
	public void remove(Remedio Remedio) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("delete from Remedios where id = ?");

			stmt.setLong(1, Remedio.getId());
			stmt.execute();
			stmt.close();

			System.out.println("Remedio Excluida com SUCESSO!");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Remedio buscaPorId(Long id) {

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from Remedios");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// System.out.println(rs.getLong("id")+ " // " + id);
				if (id == rs.getLong("id")) {
					// criando objeto Remedio
					Remedio Remedio = new Remedio();
					Remedio.setId(rs.getLong("id"));
					Remedio.setDescricao(rs.getString("descricao"));
					Remedio.setFinalizado(rs.getBoolean("finalizado"));

					if (rs.getDate("dataFinalizacao") != null) {
						// montando data atraves do calendar
						Calendar dataFinalizacao = Calendar.getInstance();
						dataFinalizacao.setTime(rs.getDate("dataFinalizacao"));

						Remedio.setDataFinalizacao(dataFinalizacao);
					}
					System.out.println("retornada Remedio:" + Remedio.getId());
					return Remedio;
				}
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Remedio Remedio) {
		String sql = "update Remedios set descricao=?, finalizado=?, dataFinalizacao=? where id=?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setString(1, Remedio.getDescricao());
			stmt.setBoolean(2, Remedio.isFinalizado());
			if (Remedio.getDataFinalizacao() != null) {
				stmt.setDate(3, new Date(Remedio.getDataFinalizacao().getTimeInMillis()));
			} else {
				stmt.setDate(3, null);
			}

			stmt.setLong(4, Remedio.getId());

			stmt.execute();
			stmt.close();

			System.out.println("DADOS ALTERADOS COM SUCESSO!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void finaliza(Long id) {

		Remedio Remedio = new RemedioDAO().buscaPorId(id);

		String sql = "update Remedios set finalizado=?, dataFinalizacao=? where id=?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setBoolean(1, true);

			stmt.setDate(2, (java.sql.Date) new Date(Calendar.getInstance().getTimeInMillis()));

			stmt.setLong(3, Remedio.getId());

			stmt.execute();
			stmt.close();

			System.out.println("DADOS ALTERADOS COM SUCESSO!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}}
