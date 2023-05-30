package banco.domains;

/**
 *
 * @author polar
 */
public class ContaRegular extends Conta {

    public ContaRegular(String tipo, Cliente cliente, double saldo) {
        super(tipo, cliente, saldo);
    }

    public void depositar(double quantia) {
        this.saldo += quantia;
    }
}
