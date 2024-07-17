package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Casa extends Financiamento {
    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    @Override
    public double calcularMensalidade() {
        double mensalidade = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual() / 12));
        BigDecimal valorArredondado = new BigDecimal(mensalidade);
        valorArredondado = valorArredondado.setScale(3, RoundingMode.HALF_UP);
        return valorArredondado.doubleValue() + 80;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nArea Construída: " + areaConstruida +
                "\nArea do Terreno: " + areaTerreno;
    }
}
