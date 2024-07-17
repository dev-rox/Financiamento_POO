package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Financiamento implements Serializable {

    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    //    constructor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // getters
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    // metodos

    public void demonstrarFinanciamento() {
        double total = calcularPagamentoTotal();
        System.out.printf("O valor do imóvel é: %.2f\n", valorImovel);
        System.out.printf("O valor da mensalidade é: %.2f\n", calcularMensalidade());
        System.out.printf("O valor total do financiamento é: %.2f\n", total);
    }

    public abstract double calcularMensalidade();

    public double calcularPagamentoTotal() {
        return calcularMensalidade() * (prazoFinanciamento * 12);
    }

    @Override
    public String toString() {
        return "\nValor do imovel: " + valorImovel +
                "\nPrazo do financiamento: " + prazoFinanciamento +
                "\nTaxa de Juros: " + taxaJurosAnual;
    }
}
