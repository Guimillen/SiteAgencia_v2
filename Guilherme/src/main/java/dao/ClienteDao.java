package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Cliente;

public class ClienteDao implements CRUD {
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	public static void create(Cliente cliente) {
		 sql = "INSERT INTO cliente VALUES (null, ?, ?, ?, ?)";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, cliente.getNome());
			 preparedStatement.setString(2, cliente.getCpf());
			 preparedStatement.setString(3, cliente.getNascimento());
			 preparedStatement.setString(4, cliente.getSituacao());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--correct insert on database");
			 
		 } catch(SQLException e) {
			 System.out.println("--incorrect insert on database. " + e.getMessage());
		 }
	}
	
	public static void delete(int clienteId) {
		sql = "DELETE FROM cliente WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, clienteId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on cliente");
			
		} catch (SQLException e) {
			System.out.println("--incorrect delete on cliente. " + e.getMessage());
		}
	}
	
	public static List<Cliente> find(String pesquisa){
		
		sql = String.format("SELECT * FROM cliente WHERE nome like '%s%%' OR cpf LIKE '%s%%' ", pesquisa, pesquisa);
		List<Cliente> cliente = new ArrayList<Cliente>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Cliente cliente1 = new Cliente();
				
				cliente1.setId(resultSet.getInt("id"));
				cliente1.setNome(resultSet.getString("nome"));
				cliente1.setCpf(resultSet.getString("cpf"));
				cliente1.setNascimento(resultSet.getString("nascimento"));
				cliente1.setSituacao(resultSet.getString("situacao"));
				

				
			}
			
			System.out.println("--correct find cliente");
			return cliente;
			
		} catch(SQLException e) {
			System.out.println("--incorrect find cliente. " + e.getMessage());
			return null;
		}
		
		
	}
	
	public static Cliente findByPk(int clienteId) {
		sql = String.format("SELECT * FROM cliente WHERE id = %d ", clienteId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Cliente cliente = new Cliente();
			
			while (resultSet.next()) {
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setSituacao(resultSet.getString("situacao"));
			}
			
			System.out.println("--correct find by pk cliente");
			return cliente;
			
	} catch(SQLException e) {
		
			System.out.println("--incorrect find by pk cliente" + e.getMessage());
			return null;
		}
	}
	
	public static void update(Cliente cliente) {
		sql = "UPDATE cliente SET nome=?, cpf=?, nascimento=?, situacao=? WHERE id=?";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, cliente.getNome());
			 preparedStatement.setString(2, cliente.getCpf());
			 preparedStatement.setString(3, cliente.getNascimento());
			 preparedStatement.setString(4, cliente.getSituacao());
			 preparedStatement.setInt(5, cliente.getId());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--correct update on database");
			 
		 } catch(SQLException e) {
			 System.out.println("--incorrect update on database. " + e.getMessage());
		 }
	}
}
