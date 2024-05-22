import java.util.Scanner;

public class InterfaceUsuario {
    double inserirValorImovel(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor do imóvel: ");
        return sc.nextDouble();
    }
    int inserirPrazoFinanciamento(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o prazo do financiamento em anos: ");
        return sc.nextInt();
    }
    double inserirTaxaJuros(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite taxa de juros anual: ");
        return sc.nextDouble();
    }
}

