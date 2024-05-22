public class Financiamento {

    double valorImovel;
    int prazoFinanciamento;
    double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual ){
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual= taxaJurosAnual;
    }

    double calcularMensalidade(){
        return (this.valorImovel/(this.prazoFinanciamento *12))*(1+(this.taxaJurosAnual/12));

    }

    double calcularPagamentoTotal(){
        return calcularMensalidade() * prazoFinanciamento * 12;
    }
    @Override
    public String toString() {
        return "Financiamento{" +
                "valor=" + this.valorImovel +
                ", prazo=" + this.prazoFinanciamento +
                ", juros=" + this.taxaJurosAnual +
                '}';
    }


}
