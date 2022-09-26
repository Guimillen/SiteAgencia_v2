package entrega2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class PassagemCrudDAO{
	
	private Connection connection;
	

	public PassagemCrudDAO() {
		this.connection = new Conexao().getConnection();
	}
	

	//Create
	//- dadosPassageiro:type = varChar
	//		- empresaAerea:type = varChar
		//	- origem:type = varChar
			//- destino:type = varChar
			//- dataViagem:type = date
			//- horario:type = time
			//- poltrona:type = in
	
	
	
	
	public void save (Passagem passagem) {
		String sql = "INSERT INTO passagem VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, passagem.getDadosPassageiro());
			stmt.setString(2, passagem.getEmpresaAerea());
			stmt.setString(3, passagem.getOrigem());
			stmt.setString(4, passagem.getDestino());
			stmt.setInt(5, passagem.getDataViagem());
			stmt.setInt(6, passagem.getHorario());
			stmt.setInt(6, passagem.getPoltrona());
			stmt.execute();
			stmt.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//Read
		public ResultSet getPassagem() throws SQLException {
			String sql = "SELECT * FROM passagem";
			Statement stmt = null;
			ResultSet resultado = null;
			try {
				stmt = connection.createStatement();
				resultado =  stmt.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultado;
			
		}
	    
		//Update
		public void update(Passagem passagem) {
			String sql = "UPDATE passagem SET  DadosPassageiro = ? , EmpresaAerea = ? , Origem = ?, Destino = ?, DataViagem = ?, Horario = ?, Poltrona = ? WHERE id = ?";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, passagem.getDadosPassageiro());
				stmt.setString(2, passagem.getEmpresaAerea());
				stmt.setString(3, passagem.getOrigem());
				stmt.setString(4, passagem.getDestino());
				stmt.setInt(5, passagem.getDataViagem());
				stmt.setInt(6, passagem.getHorario());
				stmt.setInt(6, passagem.getPoltrona());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	    
		//Delete
		public void removeById(int id) {
			String sql = "DELETE FROM passagem WHERE id= ?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setInt(1, id);
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		//Read ID
		public ResultSet getContatoById(int id) throws SQLException {
			String sql = "SELECT * FROM passagem where id = ?";
			PreparedStatement stmt = null;
			ResultSet resultado = null;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, id);
				resultado =  stmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultado;
			
		}
	
}
