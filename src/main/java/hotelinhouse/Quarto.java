package hotelinhouse;


public enum Quarto {

    SIMPLES("Simples", 90, 140),
    LUXO("Luxo", 150, 400),
    SUITE_SUPREMA("Suíte Suprema", 500, 800);

    private final String nome;
    private final int valorBaixaTemporada;
    private final int valorAltaTemporada;

    Quarto(String nome, int valorBaixaTemporada, int valorAltaTemporada) {
        this.nome = nome;
        this.valorBaixaTemporada = valorBaixaTemporada;
        this.valorAltaTemporada = valorAltaTemporada;
    }

    public int getValor(Temporada temporada) {
        return temporada == Temporada.ALTA ? valorAltaTemporada : valorBaixaTemporada;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public int getValorBaixaTemporada() {
        return valorBaixaTemporada;
    }

    public int getValorAltaTemporada() {
        return valorAltaTemporada;
    }
}
