package entrega2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadClientesDAO {
	// Testando a execução do Contato DAO Read lista completa
	Clientes clientes = new Clientes();
	
	static ClientesCrudDAO dao = new ClientesCrudDAO();

	public static void main(String[] args) {
		
	try {
		ResultSet resultado= dao.getClientes();
		while (resultado.next()) {
	    	//System.out.println(resultado.getInt(1)+" "+resultado.getString(2)+" "+resultado.getString(3)+ " "+resultado.getInt(4)+" "+resultado.getString(5)+" "+resultado.getString(6)+ " "+resultado.getString(7));
			System.out.println("\nNome: "+resultado.getString(1)+ " " +"\nRG: "+ resultado.getInt(2)+" "+"\nCPF: "+ resultado.getInt(3)+" "+"\nEndereco: "+ resultado.getString(4)+" "+"\nEmail: "+ resultado.getString(5));
	    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }

}