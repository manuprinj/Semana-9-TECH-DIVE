package hotelinhouse;


import java.time.LocalDate;
import java.time.Month;


public enum Temporada {

    ALTA("Alta Temporada"),
    BAIXA("Baixa Temporada");

    private final String nome;

    Temporada(String nome) {
        this.nome = nome;
    }

    public static Temporada getTemporada(LocalDate data) {
        if (data.getMonthValue() >= Month.NOVEMBER.getValue()
                || data.getMonthValue() <= Month.MARCH.getValue()) {
            return ALTA;
        }
        return BAIXA;
    }

    public String getNome() {
        return nome;
    }
}
