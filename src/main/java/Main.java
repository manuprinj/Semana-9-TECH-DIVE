public class Main {

    public static void main(String[] args) {
        Agencia agencia = new Agencia();

        agencia.adiciona(new ContaPoupanca(new Cliente("Manuela")));
        agencia.adiciona(new ContaPoupanca(new Cliente("Cecília")));
        agencia.adiciona(new ContaPoupanca(new Cliente("Caroline")));
        agencia.adiciona(new ContaCorrente(new Cliente("Renan")));
        agencia.adiciona(new ContaCorrente(new Cliente("Lea")));

        System.out.println(agencia.getQuantidadeContas());

        agencia.buscaPorTitular("Manuela");
    }
}
