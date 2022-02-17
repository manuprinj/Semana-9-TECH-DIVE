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
            try {
                Quarto quarto = getQuarto();
                LocalDate inicioReserva = getData("Digite a data inicial da reserva: ");
                if (inicioReserva.isBefore(LocalDate.now())) throw new IllegalArgumentException("Essa data já passou!!");
                if (inicioReserva.isAfter(LocalDate.now().plusDays(60))) throw new IllegalArgumentException("Só pode reservar com 60 dias de antecedência!!");

                LocalDate fimReserva = getData("Digite a data final da reserva: ");
                if (fimReserva.isBefore(inicioReserva)) throw new IllegalArgumentException("O fim não pode ser antes do início!!");

                List<String> cpfDependentes = new ArrayList<>();
                cpfDependentes.add(hospede.getCpfHospede());

                System.out.println("Quantas pessoas ficarão no quarto?");
                int pessoas = getInt();
                for (int i = 1; i < pessoas; i++) {
                    cpfDependentes.add(getCPF("Digite o CPF do hospede " + (i + 1) + ": "));
                }
                hospede.getReservas().add(new Reserva(quarto, inicioReserva, fimReserva, cpfDependentes));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void cancelarReserva() {
        Hospede hospede = getHospede();
        if (hospede != null) {
            System.out.println("Selecione a reserva para cancelar: ");
            for (int i = 0; i < hospede.getReservas().size(); i++) {
                Reserva reserva = hospede.getReservas().get(i);
                System.out.println(i + 1 + " - " + reserva + " ");
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
            if (hospede.getReservas().isEmpty()) {
                System.out.println("Sem reservas!!");
            } else {
                System.out.println("Reservas:");
                for (Reserva reserva : hospede.getReservas()) {
                    System.out.println(reserva);
                }
            }
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
                if (!reserva.getInicio().isAfter(dataReserva) && !reserva.getFim().isBefore(dataReserva)) {
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
