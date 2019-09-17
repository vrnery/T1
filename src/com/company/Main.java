package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static String nNodo;

    public static void main(String[] args) {
	// write your code here
        try {
            long inTemp = System.currentTimeMillis();

            FileReader arq = new FileReader("H:\\Semestre4\\alest2\\T1\\arquivo_teste\\casom3.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();

            String[] nLinha = linha.split(" ");

            ArrayList<String> nLista = new ArrayList<>();

            for (String n: nLinha) {
                nLista.add(n);
            }

            nNodo = "1";

            XTree raiz = new XTree(nNodo, nLista);

            //raiz.printNodo();

            System.out.printf("Altura maxima: %d\nSomaTotal: %d\nTimer: %.3f m/s\n",raiz.getAlturaMaxima(),raiz.getSomaTotal(),((System.currentTimeMillis() - inTemp)/1000d));

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }
}
