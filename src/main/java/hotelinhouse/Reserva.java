package hotelinhouse;


import java.time.LocalDate;
import java.time.Month;
import java.util.StringJoiner;


public class Reserva {

    private Quarto quarto;
    private LocalDate data;

    public Reserva(Quarto quarto, LocalDate data) {
        this.quarto = quarto;
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringJoiner(" | ")
                .add("Quarto: " + quarto)
                .add("Data: " + data)
                .add("Temporada: " + getTemporada().getNome())
                .add("Valor: " + quarto.getValor(getTemporada()))
                .toString();
    }

    public Temporada getTemporada() {
        return Temporada.getTemporada(data);
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
