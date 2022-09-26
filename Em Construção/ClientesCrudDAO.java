package entrega2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ClientesCrudDAO{
	
	private Connection connection;
	

	public ClientesCrudDAO() {
		this.connection = new Conexao().getConnection();
	}
	

	//Create
	public void save (Clientes clientes) {
		String sql = "INSERT INTO clientes VALUES (?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, clientes.getNome());
			stmt.setInt(2, clientes.getRg());
			stmt.setInt(3, clientes.getCpf());
			stmt.setString(4, clientes.getEndereco());
			stmt.setString(5, clientes.getEmail());
			stmt.execute();
			stmt.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//Read
		public ResultSet getClientes() throws SQLException {
			String sql = "SELECT * FROM clientes";
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
		public void update(Clientes clientes) {
			String sql = "UPDATE clientes SET  nome = ? ,rg = ? , cpf = ?, endereco = ?, email = ? WHERE id = ?";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, clientes.getNome());
				stmt.setInt(2, clientes.getRg());
				stmt.setInt(3, clientes.getCpf());
				stmt.setString(4, clientes.getEndereco());
				stmt.setString(5, clientes.getEmail());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	    
		//Delete
		public void removeById(int id) {
			String sql = "DELETE FROM clientes WHERE id= ?";
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
			String sql = "SELECT * FROM clientes where id = ?";
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