package model;

public class Apartamento extends Financiamento {
    private int vagasGaragem;
    private int numeroAndar;


    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calcularMensalidade() {

        double taxaMensal = super.getTaxaJurosAnual() / 12;
        int meses = getPrazoFinanciamento() * 12;
        return (Math.pow(1 + taxaMensal, meses) * getValorImovel() * taxaMensal) / (Math.pow(1 + taxaMensal, meses) - 1);
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nVagas de garagem: " + vagasGaragem +
                "\nAndar: " + numeroAndar;
    }
}
