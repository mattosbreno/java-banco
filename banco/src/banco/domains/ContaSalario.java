package banco.domains;

/**
 *
 * @author polar
 */
public class ContaSalario extends Conta {

    public ContaSalario(String tipo, Cliente cliente, double saldo) {
        super(tipo, cliente, saldo);
    }

    public void depositoEmpregador(double quantia) {
        this.saldo += quantia;
        balanco += quantia;
    }
}
