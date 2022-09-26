package entrega2;

public class ClientesDeleteDAO {

	public static void main(String[] args) {

		ClientesCrudDAO dao = new ClientesCrudDAO();
								
		dao.removeById(1);
        System.out.println("Contato removido com sucesso!");

	}

}