package dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.IDao;

public class MarcaDao implements IDao<Marca>{
	
	private Connection connection;
	
	public MarcaDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void save(Marca m) {
		
		String SQL = "insert into marca (nome) values (?)";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			pstmt.setString(1, m.getNome());
			pstmt.execute();
			System.out.println("marca inserida com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public Marca getOne(int id) {
		
		Marca m = null;
		try {
			Statement sta = connection.createStatement();
			ResultSet elements = sta.executeQuery("select * from marca "
					+ "where id = " + id);
			while (elements.next()) {
				m = new Marca();
				m.setId(elements.getInt("id"));
				m.setNome(elements.getString("nome"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return m;
	}

	@Override
	public List<Marca> list() {
		
		ArrayList<Marca> m = new ArrayList<Marca>();
		Marca m2 = null;
		try {
			Statement sta = connection.createStatement();
			ResultSet elements = sta.executeQuery("select * from livro ");
			while (elements.next()) {
				m2 = new Marca();
				m2.setId(elements.getInt("id"));
				m2.setNome(elements.getString("nome"));
				m.add(m2);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return m;
	}

	@Override
	public void update(Marca t) {
		
		String SQL = "Update marca set nome=? where id = ?";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			pstmt.setString(1, t.getNome());
			pstmt.setInt(2, t.getId());
			pstmt.execute();
			System.out.println("Marca atualizada com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		
		String SQL = "delete from marca where id = ?";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			pstmt.setInt(1, id);
			pstmt.execute();
			System.out.println("Marca excluida com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
