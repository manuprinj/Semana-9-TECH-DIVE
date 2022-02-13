package exercicioquatro;


import java.util.Scanner;


public class Questao4 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Eu sei dividir");
        System.out.println("Informe o primeiro valor");
        int x = teclado.nextInt();
        Integer y = null;

        while (y == null) {
            try {
                System.out.println("Informe o segundo valor");
                int input = teclado.nextInt();
                if (input == 0) {
                    throw new IllegalArgumentException("O valor não pode ser zero!");
                }
                y = input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        double r = (double) x / y;
        System.out.println("Resultado da divisão: " + r);
    }
}
