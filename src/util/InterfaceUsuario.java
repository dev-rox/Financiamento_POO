package util;

import java.util.Scanner;

public class InterfaceUsuario {


    /*
    No método "inserirValorImovel()" abaixo, utilizei a palavra-chave throws para indicar que o método pode gerar uma
    exceção do tipo ValorInvalidoException.
    Quem chamar esse método deve estar preparado para tratar a exceção (usando try/catch) ou propagá-la para cima na pilha de chamadas.
    No caso, o tratamento está sendo feito em Main.java na execução do código.
    */

    public double inserirValorImovel() throws ValorInvalidoException{
        Scanner sc = new Scanner(System.in);
        double a;
        System.out.println("Digite o valor do imóvel: ");
            a = Double.parseDouble(sc.nextLine());
            if (a < 0) {
                throw new ValorInvalidoException("Erro: Valor inválido, insira um valor positivo.");
            }
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

