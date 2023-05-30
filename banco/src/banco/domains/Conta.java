package banco.domains;

/**
 *
 * @author polar
 */
public abstract class Conta {

    protected String tipo;
    protected String numero;
    protected double saldo;
    protected Cliente cliente;

    public static int quantidadeContas = 0;
    public static double balanco = 0.0;

    public Conta(String tipo, Cliente cliente, double saldo) {
        this.tipo = tipo;
        this.cliente = cliente;
        this.saldo = saldo;

        quantidadeContas += 1;
        this.numero = String.valueOf(quantidadeContas);
        balanco += saldo;

    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean sacar(double quantia) {
        if (this.saldo < quantia) {
            return false;
        }
        this.saldo -= quantia;
        balanco -= quantia;
        return true;
    }

    @Override
    public String toString() {
        String info = "";
        info += "Tipo de conta: " + this.tipo + "\n";
        info += "Número: " + this.numero + "\n";
        info += "Nome: " + this.cliente.getNome() + "\n";
        info += "Sexo: " + this.cliente.getSexo() + "\n";
        info += "Saldo: " + this.saldo + "\n";
        info += "------------------------------------------------------\n";

        return info;
    }

}
