package hotelinhouse;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.StringJoiner;


public class Reserva {

    private Quarto quarto;
    private LocalDate inicio;
    private LocalDate fim;
    private List<String> cpfDependentes;

    public Reserva(Quarto quarto, LocalDate inicio, LocalDate fim, List<String> cpfDependentes) {
        this.quarto = quarto;
        this.inicio = inicio;
        this.fim = fim;
        this.cpfDependentes = cpfDependentes;
    }

    @Override
    public String toString() {
        return new StringJoiner(" | ")
                .add("Quarto: " + quarto)
                .add("Data: " + inicio + " - " + fim)
                .add(getTemporada().getNome())
                .add("Valor: R$ " + getValor() + ",00")
                .add("Pessoas: " + String.join(", ", cpfDependentes))
                .toString();
    }

    public Temporada getTemporada() {
        return Temporada.getTemporada(inicio);
    }

    public int getValor() {
        return Period.between(inicio, fim).getDays() * quarto.getValor(getTemporada());
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public List<String> getCpfDependentes() {
        return cpfDependentes;
    }

    public void setCpfDependentes(List<String> cpfDependentes) {
        this.cpfDependentes = cpfDependentes;
    }
}