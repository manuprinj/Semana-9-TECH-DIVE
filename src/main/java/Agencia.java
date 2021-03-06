import static utils.EntradaUtils.getString;

import java.util.ArrayList;
import java.util.List;


public class Agencia {

    List<Conta> contas = new ArrayList<>();

    public void adiciona (Conta conta) {
        contas.add(conta);
    }

    public int getQuantidadeContas() {
        return contas.size();
    }

    public Conta buscaPorTitular(String nomeDoTitular) {
        for (Conta conta : contas) {
            if (conta.getCliente().getNome().equals(nomeDoTitular)) {
                System.out.println(conta);
            }
        }
        return null;
    }
}
