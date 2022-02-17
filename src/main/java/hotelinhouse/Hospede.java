package hotelinhouse;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import utils.ValidacaoCPF;


public class Hospede {

    private String cpfHospede;
    private LocalDate dataNascimento;
    private List<Reserva> reservas;

    public Hospede(String cpfHospede, LocalDate dataNascimento) {
        this.cpfHospede = cpfHospede;
        this.dataNascimento = dataNascimento;
        this.reservas = new ArrayList<>();
    }

    @Override
    public String toString () {
        StringJoiner joiner = new StringJoiner(" | ")
                .add("CPF: " + ValidacaoCPF.getMascaraCPF(getCpfHospede()))
                .add("Data de Nascimento: " + getDataNascimento());
        return joiner.toString();
    }

    public String getCpfHospede() {
        return cpfHospede;
    }

    public void setCpfHospede(String cpfHospede) {
        this.cpfHospede = cpfHospede;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
