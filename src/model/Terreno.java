package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Terreno extends Financiamento {
    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calcularMensalidade() {
        double mensalidade = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual() / 12));
        BigDecimal valorArredondado = new BigDecimal(mensalidade);
        valorArredondado = valorArredondado.setScale(3, RoundingMode.HALF_UP);
        return valorArredondado.doubleValue() * 1.02;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nZona: " + tipoZona;
    }
}
