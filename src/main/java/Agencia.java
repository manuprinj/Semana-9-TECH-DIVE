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
}
