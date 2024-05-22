//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        InterfaceUsuario user1 = new InterfaceUsuario();

        double valor = user1.inserirValorImovel();
        int prazo = user1.inserirPrazoFinanciamento();
        double juros = user1.inserirTaxaJuros();


        Financiamento financ1 = new Financiamento(valor,prazo,juros);


        System.out.println(financ1);

        System.out.println(financ1.calcularMensalidade());



    }
}


