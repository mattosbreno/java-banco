package banco.domains;

/**
 *
 * @author polar
 */
public class ContaCorrente extends ContaRegular {

    public ContaCorrente(String tipo, Cliente cliente, double saldo) {
        super(tipo, cliente, saldo);
    }

    public boolean transferencia(double quantia, Conta destino) {
        if (saldo < quantia) {
            return false;
        }
        this.saldo -= quantia;
        return true;
    }
}
