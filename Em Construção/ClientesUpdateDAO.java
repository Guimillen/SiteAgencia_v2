package entrega2;

public class ClientesUpdateDAO {

	public static void main(String[] args) {
		// Testando a execução do Contato DAO Update
		Clientes clientes = new Clientes();
				
		ClientesCrudDAO dao = new ClientesCrudDAO();
				
		clientes.setNome("Luiz Inácio Lula da Silva");
		clientes.setRg(13131313);
		clientes.setCpf(13131313);
		clientes.setTelefone(123456789);
		clientes.setEmail("lula.presidente2022@gmail.com");
		
		dao.update(clientes);
		System.out.println("Contato alterado com sucesso!");

			}

		}