package dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.IDao;

public class VeiculoDao implements IDao<Veiculo> {
	
private Connection connection;
	
	public VeiculoDao(Connection connection) {
		this.connection = connection;
	}
	
	public void save(Veiculo v) {
		
		String SQL = "insert into Veiculo (ano, modelo, tipo,"
				+ "cilindrada, motor, idMarca) values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			pstmt.setInt(1, v.getAno());
			pstmt.setString(2,v.getModelo());
			pstmt.setString(3, v.getTipo());
			if (v.getTipo()=="carro") {
				pstmt.setInt(4, 0);
				pstmt.setString(5, ((Carro) v).getMotor());
			} else {
				pstmt.setInt(4, ((Moto) v).getCilindrada());
				pstmt.setString(5, "0");
			}
			pstmt.setInt(6, v.getMarca());
			pstmt.execute();
			System.out.println("Veiculo inserido com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public Veiculo getOne(int id) {
		
		Veiculo v = null;
		try {
			Statement sta = connection.createStatement();
			ResultSet elements = sta.executeQuery("select * from veiculo inner join marca on veiculo.idMarca = marca.id "
					+ "where veiculo.id = " + id);
			while (elements.next()) {
				v = new Veiculo();
				v.setId(elements.getInt("id"));
				v.setAno(elements.getInt("ano"));
				v.setModelo(elements.getString("modelo"));
				v.setTipo(elements.getString("tipo"));
				if (v.getTipo()=="carro") {
					((Carro)v).setMotor(elements.getString("motor"));
				} else if (v.getTipo()=="moto") {
					((Moto) v).setCilindrada(elements.getInt("cilindrada"));
				}
				v.setNomeMarca(elements.getString("marca.nome"));
			}
		} catch (SQLException ex2) {
			ex2.printStackTrace();
		}
		return v;
	}
	
	

	@Override
	public List<Veiculo> list() {
		
		ArrayList<Veiculo> v = new ArrayList<Veiculo>();
		Veiculo v2 = null;
		try {
			Statement sta = connection.createStatement();
			ResultSet elements = sta.executeQuery("select * from veiculo inner join marca on veiculo.idMarca = marca.id ");
			while (elements.next()) {
				v2 = new Veiculo();
				v2.setId(elements.getInt("id"));
				v2.setAno(elements.getInt("ano"));
				v2.setModelo(elements.getString("modelo"));
				v2.setNomeMarca(elements.getString("marca.nome"));
				v2.setTipo(elements.getString("tipo"));
				v.add(v2);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return v;
	}

	@Override
	public void update(Veiculo v) {
		
		String SQL = "Update veiculo set ano=?, modelo = ?, idMarca = ?,"
				+ "tipo = ?, motor = ?, cilindrada = ? where id = ?";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			pstmt.setInt(1, v.getAno());
			pstmt.setString(2, v.getModelo());
			pstmt.setInt(3, v.getMarca());
			pstmt.setString(4, v.getTipo());
			if (v.getTipo()=="carro") {
				pstmt.setInt(6, 0);
				pstmt.setString(5, ((Carro) v).getMotor());
			} else {
				pstmt.setInt(6, ((Moto) v).getCilindrada());
				pstmt.setString(5, "0");
			}
			pstmt.setInt(7, v.getId());
			pstmt.execute();
			System.out.println("Veiculo atualizado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id){
		
		String SQL = "delete from veiculo where id = ?";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			pstmt.setInt(1, id);
			pstmt.execute();
			System.out.println("veiculo excluido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}


