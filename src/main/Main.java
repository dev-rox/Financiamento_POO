package main;

import model.Financiamento;
import util.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {

        InterfaceUsuario user1 = new InterfaceUsuario();

        double valor = user1.inserirValorImovel();
        int prazo = user1.inserirPrazoFinanciamento();
        double juros = user1.inserirTaxaJuros();


        Financiamento financ1 = new Financiamento(valor, prazo, juros);
        financ1.demonstrarFinanciamento();

    }
}


