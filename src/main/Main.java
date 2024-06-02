package main;

import model.Financiamento;
import util.InterfaceUsuario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        InterfaceUsuario user = new InterfaceUsuario();

        for (int i = 0; i < 4; i++) {
            System.out.println();

            System.out.println("Por favor, informe os valores do " + (i + 1) + "° financiamento.\n");

            double valor = user.inserirValorImovel();
            int prazo = user.inserirPrazoFinanciamento();
            double juros = user.inserirTaxaJuros();


            financiamentos.add(new model.Financiamento(valor, prazo, juros));

            Financiamento select = financiamentos.get(i);
            System.out.println();
            System.out.println("----------------------------\n");
            select.demonstrarFinanciamento();
            System.out.println("Financiamento armazenado a lista!\n");
            System.out.println("----------------------------\n");


        }
        double valorImoveis = 0;
        double valorFinanciamentos = 0;

        int i = 1;
        for (Financiamento f : financiamentos) {
            valorImoveis += f.getValorImovel();
            valorFinanciamentos += f.calcularPagamentoTotal();

            System.out.printf("Financiamento %d – valor do imóvel: R$ %.2f. Valor do financiamento: R$ %.2f.\n", i, f.getValorImovel(), f.calcularPagamentoTotal());
            i++;
        }

        System.out.printf("Total de todos os imóveis: R$ %.2f, total de todos os financiamentos: R$ %.2f.", valorImoveis, valorFinanciamentos);


    }
}


