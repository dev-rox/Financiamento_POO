package model;

public class Financiamento {

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

    //    metodos

    public void demonstrarFinanciamento() {
        double total = calcularPagamentoTotal();

        System.out.printf("O valor total do financiamento é: %.2f\n", total);
        System.out.printf("O valor do imóvel é: %.2f", valorImovel);
    }

    public double calcularMensalidade() {
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));

    }

    public double calcularPagamentoTotal() {
        return calcularMensalidade() * prazoFinanciamento * 12;
    }

    @Override
    public String toString() {
        return "model.Financiamento{" +
                "valor=" + this.valorImovel +
                ", prazo=" + this.prazoFinanciamento +
                ", juros=" + this.taxaJurosAnual +
                '}';
    }


}
