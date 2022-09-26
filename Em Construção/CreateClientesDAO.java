package entrega2;

public class CreateClientesDAO {

	public static void main(String[] args) {
		// Testando a execução do Contato DAO Create
		
		Clientes clientes = new Clientes();
		

		clientes.setNome("Guilherme Millen Azevedo");
		clientes.setRg(75395185);
		clientes.setCpf(987654321);
		clientes.setTelefone(123456789);
		clientes.setEmail("millen.guilherme@gmail.com");
		
		
		ClientesCrudDAO dao = new ClientesCrudDAO();
		
	    dao.save(clientes);
	    System.out.println("Contato salvo com sucesso!");
				
				

	}

}