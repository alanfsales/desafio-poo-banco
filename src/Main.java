public class Main {
    public static void main(String[] args) {

        Conta c1 = new Conta(new Cliente("Cliente 1"));
        Conta c2 = new ContaCorrente(new Cliente("Cliente 2"));
        Conta c3 = new ContaPoupanca(new Cliente("Cliente 3"));

       c2.depositar(25);
       c2.sacar(10);
       c2.transferir(15, c3);
       c2.imprimirInfosComuns();

    }
}