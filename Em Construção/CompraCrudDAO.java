package entrega2;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class CompraCrudDAO {
	
	private Connection connection;
	

	public CompraCrudDAO() {
		this.connection = new Conexao().getConnection();
	}
	

	//Create
	public void save (Compra compra) {
		String sql = "INSERT INTO compra VALUES (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, compra.getIdPedido());
			stmt.setString(2, compra.getFormaPgto());
			stmt.setBoolean(3, compra.isAprovado());
			stmt.execute();
			stmt.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//Read
		public ResultSet getCompra() throws SQLException {
			String sql = "SELECT * FROM compra";
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
		public void update(Compra compra) {
			String sql = "UPDATE clientes SET  idPedido = ? ,formaPgto = ?, aprovado = ? WHERE id = ?";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
					stmt.setInt(1, compra.getIdPedido());
					stmt.setString(2, compra.getFormaPgto());
					stmt.setBoolean(3, compra.isAprovado());
					stmt.execute();
					stmt.close();	
		
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	    
		//Delete
		public void removeById(int id) {
			String sql = "DELETE FROM compra WHERE id= ?";
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
			String sql = "SELECT * FROM compra where id = ?";
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
