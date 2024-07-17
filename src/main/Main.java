package main;

import model.Apartamento;
import model.Casa;
import model.Financiamento;
import model.Terreno;
import util.InterfaceUsuario;
import util.ValorInvalidoException;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ValorInvalidoException {

        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        InterfaceUsuario user = new InterfaceUsuario();

        System.out.println("Por favor, informe os valores do financiamento.\n");

        double valor;
        while (true) {
            try {
                valor = user.inserirValorImovel();
                break;
            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        int prazo = user.inserirPrazoFinanciamento();
        double juros = user.inserirTaxaJuros();

        for (int i = 0; i <= 4; i++) {

            if (i < 2) {
                financiamentos.add(new Casa(valor, prazo, juros, 200, 400));

            } else if (i < 4) {
                financiamentos.add(new Apartamento(valor, prazo, juros, 1, 10));

            } else {
                financiamentos.add(new Terreno(valor, prazo, juros, "Rural"));

            }

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


        // salvando os dados dos financiamentos em um arquivo de texto.
        FileWriter out = null;
        StringBuilder sb = new StringBuilder();
        int contLetra = 0;
        String texto = "";

        for (Financiamento f : financiamentos) {


            sb.append(f.toString()).append("\n");
            texto = sb.toString();
        }

        try {
            out = new FileWriter("arqChar1.txt");
            while (contLetra < texto.length()) {
                out.write(texto.charAt(contLetra));// escreve caractere a caractere
                contLetra++;
            }
            out.close(); // fecha arquivo de saída
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ler arquivo que foi gerado
        System.out.println("\n\n\n\nIniciando a leitura do arquivo: ");

        FileReader in = null;
        try {
            in = new FileReader("arqChar1.txt");
            int c;
            while ((c = in.read()) != -1) { // escreve caractere a caractere; -1 = EOF
                System.out.print((char) c); // imprime como caractere
            }
            in.close(); // fecha arquivo de entrada

        } catch (
                IOException e) {
            e.printStackTrace();
        }

        // Gravando objetos

        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("lista.obj"));
            outputStream.writeObject(financiamentos);
            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lendo objetos do arquivo
        System.out.println("\n\n\nIniciando leitura do arquivo de objetos: ");


        ArrayList<Financiamento> arquivoLista = null;

        try (FileInputStream fis = new FileInputStream("lista.obj");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                arquivoLista = (ArrayList<Financiamento>) obj;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (arquivoLista != null) {
            for (Financiamento f : arquivoLista) {
                System.out.println(f);
            }
        }


    }
}
