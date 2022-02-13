import java.util.StringJoiner;


public abstract class Conta {

    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" | ")
                .add("Cliente: " + cliente.getNome());

        return joiner.toString();
    }
}
