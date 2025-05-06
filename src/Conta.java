import java.util.Objects;

public class Conta  implements IConta{

    private static int SEQUENCIA = 1;

    private int agencia;
    private int numero;
    private double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = 1;
        this.numero = SEQUENCIA++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void sacar(double valor) {
        if(valor <= 0){
            System.out.println("Valor Inválido");
        }else if (this.saldo >= valor){
            this.saldo -= valor;
        }else {
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if(valor <= 0){
            System.out.println("Valor Inválido");
        }else if(contaDestino.equals(this)){
            System.out.println("Conta Inválida");
        }else if(this.saldo >= valor){
            sacar(valor);
            contaDestino.depositar(valor);
        }else{
            System.out.println("Saldo insuficiente");
        }
    }

    public void imprimirInfosComuns() {
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Numero: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta conta)) return false;
        return getAgencia() == conta.getAgencia() && getNumero() == conta.getNumero();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAgencia(), getNumero());
    }
}
