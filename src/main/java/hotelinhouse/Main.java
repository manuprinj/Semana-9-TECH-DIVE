package hotelinhouse;


import static utils.EntradaUtils.getCPF;
import static utils.EntradaUtils.getData;
import static utils.EntradaUtils.getInt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static List<Hospede> hospedes = new ArrayList<>();

    public static void menu() {
        while (true) {
            System.out.println("Seja bem-vindo ao HotelInHouse");
            System.out.println("1 - Cadastrar Hóspede");
            System.out.println("2 - Fazer Reserva");
            System.out.println("3 - Cancelar Reserva");
            System.out.println("4 - Consultar Hóspede");
            System.out.println("5 - Consultar Reserva");
            System.out.println("6 - Sair");
            int tipoOperacao = getInt();

            if (tipoOperacao == 1) cadastroHospede();
            else if (tipoOperacao == 2) cadastroReserva();
            else if (tipoOperacao == 3) cancelarReserva();
            else if (tipoOperacao == 4) listarHospedeEspecifico();
            else if (tipoOperacao == 5) listarReservaEspecifica();
            else if (tipoOperacao == 6) return;
            else System.out.println("Digite uma opção válida!!");

        }
    }

    public static void cadastroHospede() {
        String cpf = getCPF("Digite seu CPF:");
        LocalDate dataNascimento = getData("Digite sua data de nascimento: ");

        Hospede hospede = new Hospede(cpf, dataNascimento);
        hospedes.add(hospede);
    }

    public static void cadastroReserva() {
        Hospede hospede = getHospede();
        if (hospede != null) {
            LocalDate dataReserva = getData("Digite a data da reserva: ");
            if (dataReserva.isBefore(LocalDate.now())) {
                System.out.println("Data inválida!!");
            } else {
                hospede.getReservas().add(new Reserva(getQuarto(), dataReserva));
            }
        }
    }

    public static void cancelarReserva() {
        Hospede hospede = getHospede();
        if (hospede != null) {
            System.out.println("Selecione a reserva para cancelar: ");
            for (int i = 0; i < hospede.getReservas().size(); i++) {
                Reserva reserva = hospede.getReservas().get(i);
                System.out.println(i + 1 + " - " + reserva.getData() + " ");
            }
            int indexReserva = getInt() - 1;
            hospede.getReservas().remove(indexReserva);
        }
    }

    private static Quarto getQuarto() {
        System.out.println("Selecione o tipo de quarto:");
        for (Quarto value : Quarto.values()) {
            System.out.println(value.ordinal() + 1 + " - " + value.getNome());
        }
        int opcaoQuarto = getInt() - 1;
        return Quarto.values()[opcaoQuarto];
    }

    public static void listarHospedeEspecifico() {
        Hospede hospede = getHospede();
        if (hospede != null) {
            System.out.println(hospede);
        }
    }

    public static Hospede getHospede() {
        String cpf = getCPF("Digite o CPF do hóspede:");
        for (Hospede hospede : hospedes) {
            if (hospede.getCpfHospede().equals(cpf)) {
                return hospede;
            }
        }
        System.out.println("Hóspede não encontrado!");
        return null;
    }

    public static void listarReservaEspecifica() {
        LocalDate dataReserva = getData("Digite a data da reserva: ");
        for (Hospede hospede : hospedes) {
            for (Reserva reserva : hospede.getReservas()) {
                if (reserva.getData().equals(dataReserva)) {
                    System.out.println(hospede);
                    System.out.println(reserva);
                }
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
