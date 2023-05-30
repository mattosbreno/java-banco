package banco.models;

import banco.domains.Cliente;
import banco.utils.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.ResultSet;

/**
 *
 * @author polar
 */
public class ClienteDAO {

    Connection conexao;

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        conexao = DBConnection.getConnection();

        String sql = "SELECT * FROM clientes ORDER BY codigo DESC";
        PreparedStatement stmt;

        try {
            stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getString("nome"), rs.getString("sexo").charAt(0), rs.getString("email"), rs.getString("telefone"), rs.getString("civil"));
                cliente.setId(rs.getInt("codigo"));

                clientes.add(cliente);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientes;
    }

    public void inserirCliente(Cliente cliente) throws SQLIntegrityConstraintViolationException, SQLException {
        String sql = "INSERT INTO clientes (nome, sexo, email, telefone, civil) VALUES (?, ?, ?, ?, ?)";
        conexao = DBConnection.getConnection();
        PreparedStatement stmt = null;

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, String.valueOf(cliente.getSexo()));
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getCivil());

            stmt.execute();

            stmt.close();
            conexao.close();
    }

    public void editarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nome = ?, sexo = ?, email = ?, telefone = ?, civil = ? WHERE codigo = ?";
        conexao = DBConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, String.valueOf(cliente.getSexo()));
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getCivil());
            stmt.setInt(6, cliente.getId());

            stmt.execute();

            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void excluirCliente(Cliente cliente) {
        String sql = "DELETE FROM clientes WHERE codigo = ?";

        conexao = DBConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());

            stmt.execute();

            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
