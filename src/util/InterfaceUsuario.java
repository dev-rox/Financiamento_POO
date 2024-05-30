package util;

import java.util.Scanner;

public class InterfaceUsuario {
    public double inserirValorImovel() {
        Scanner sc = new Scanner(System.in);
        double a;
        do {
            System.out.println("Digite o valor do imóvel: ");
            a = sc.nextDouble();
            if (a < 0) {
                System.out.println("Valor inválido, insira um valor positivo.");
            }
        } while (a < 0);
        return a;
    }

    public int inserirPrazoFinanciamento() {
        Scanner sc = new Scanner(System.in);
        int a;
        do {
            System.out.println("Digite o prazo do financiamento em anos: ");
            a = sc.nextInt();
            if (a < 0) {
                System.out.println("Valor inválido, insira um valor positivo.");
            }

        } while (a < 0);
        return a;

    }

    public double inserirTaxaJuros() {
        Scanner sc = new Scanner(System.in);
        double a;
        do {
            System.out.println("Digite taxa de juros anual: ");
            a = sc.nextDouble();
            if (a < 0) {
                System.out.println("Valor inválido, insira um valor positivo.");
            }
        } while (a < 0);
        return a;
    }
}

