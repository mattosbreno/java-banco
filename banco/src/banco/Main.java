package banco;

import banco.controllers.ClienteBean;
import banco.domains.Cliente;
import banco.models.ClienteDAO;
import banco.views.JFCliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author polar
 */
public class Main {

    public static void main(String[] args) {
        ClienteBean clienteBean = new ClienteBean();
        clienteBean.iniciar();
        /*
        Cliente cliente = new Cliente("Felipe Pires", 'M');

        ClienteDAO clienteDAO = new ClienteDAO();
        
        clienteDAO.inserirCliente(cliente);

        /*
        List<Cliente> clientes = new ArrayList();
        
        ClienteDAO clienteDAO = new ClienteDAO();
        clientes = clienteDAO.listarClientes();
        
        for(Cliente cliente : clientes) {
            System.out.println(cliente.getNome());
        }
        /*
        JFCliente formCliente = new JFCliente();
        formCliente.setVisible(false);
         */
    }
}
