package entrega2;

import java.sql.*;


//Classe para testar o acesso ao BD, nao esqueça de deixar usuário e senha em branco na hora de enviar os arquivos


public class Driver {
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/";
	private static final String USERNAME = "root";
	private static final String PASSWORD="";

	public static void main(String[] args) {
		

		
		try {
			Connection con = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
			
			if (con != null) {
				System.out.println("Conexão realizada com sucesso!");
			} else {
				System.out.println("Não foi possível realizar conexão.");
			}
			
			
			con.close();
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}