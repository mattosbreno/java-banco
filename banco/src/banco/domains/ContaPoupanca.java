package banco.domains;

/**
 *
 * @author polar
 */
public class ContaPoupanca extends ContaRegular {
    private double taxa;

    public ContaPoupanca(String tipo, Cliente cliente, double saldo) {
        super(tipo, cliente, saldo);
    }

    public void rendimento(double taxa) {
        double rendimento = (this.saldo * taxa / 100);
        this.saldo += rendimento;
        balanco += rendimento;
    }
}
