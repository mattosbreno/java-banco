package banco.domains;

/**
 *
 * @author polar
 */
public class ContaInvestimento extends Conta {

    public ContaInvestimento(String tipo, Cliente cliente, double saldo) {
        super(tipo, cliente, saldo);
    }

    public void depositoPorTempo(double quantia) {
        this.saldo += quantia;
        balanco += quantia;
    }

    public boolean sacar(double quantia, int mes, int ano) {
        int qtdeMeses = 12;
        if (this.saldo < quantia) {
            return false;
        }
        this.saldo -= quantia;
        balanco -= quantia;
        return true;
    }
}
