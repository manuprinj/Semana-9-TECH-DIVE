public class Main {

    public static void main(String[] args) {
        Agencia agencia = new Agencia();

        agencia.adiciona(new ContaPoupanca());
        agencia.adiciona(new ContaPoupanca());
        agencia.adiciona(new ContaPoupanca());
        agencia.adiciona(new ContaCorrente());
        agencia.adiciona(new ContaCorrente());

        System.out.println(agencia.getQuantidadeContas());
    }
}
