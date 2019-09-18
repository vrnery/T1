package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static String nNodo;
    static int numNodo;

    public static int getNumNodo() {
        return numNodo;
    }

    public static void setZeraNumNodo() {
        numNodo = 0;
    }

    public static void setAddNumNodo() {
        numNodo++;
    }

    public static void main(String[] args) {
	// write your code here
        File[] arquive = new File[8];
        arquive[0] = new File(Main.class.getResource(Main.class.getSimpleName()+".class"+"/../teste/casom3.txt").getPath());
        arquive[1] = new File(Main.class.getResource(Main.class.getSimpleName()+".class"+"/../teste/casom5.txt").getPath());
        arquive[2] = new File(Main.class.getResource(Main.class.getSimpleName()+".class"+"/../teste/casom7.txt").getPath());
        arquive[3] = new File(Main.class.getResource(Main.class.getSimpleName()+".class"+"/../teste/casom9.txt").getPath());
        arquive[4] = new File(Main.class.getResource(Main.class.getSimpleName()+".class"+"/../teste/casom10.txt").getPath());
        arquive[5] = new File(Main.class.getResource(Main.class.getSimpleName()+".class"+"/../teste/casom11.txt").getPath());
        arquive[6] = new File(Main.class.getResource(Main.class.getSimpleName()+".class"+"/../teste/casom12.txt").getPath());
        arquive[7] = new File(Main.class.getResource(Main.class.getSimpleName()+".class"+"/../teste/casom13.txt").getPath());

        for (int i=0; i<8; i++) {
            long somaParciais = 0;


            System.out.printf("\nExecutando com arquivo %s", arquive[i].getName());

            for (int j=0; j<10; j++) {
                long inTemp = System.currentTimeMillis();

                setZeraNumNodo();

                try {
                    FileReader arq = new FileReader(arquive[i]);
                    BufferedReader lerArq = new BufferedReader(arq);

                    String linha = lerArq.readLine();

                    String[] nLinha = linha.split(" ");

                    ArrayList<String> nLista = new ArrayList<>();

                    for (String n : nLinha) {
                        nLista.add(n);
                    }

                    nNodo = "1";

                    XTree raiz = new XTree(nNodo, nLista);

                    //raiz.printNodo();

                    long outTemp = System.currentTimeMillis();

                    System.out.printf("\n\tIteração: %d\n\tTotal nodos: %d\n\tAltura maxima: %d\n\tSomaTotal: %d\n\tTimer Execute: %.3f m/s\n", j, getNumNodo(), raiz.getAlturaMaxima(), raiz.getSomaTotal(), ((outTemp - inTemp) / 1000d));

                    somaParciais += (outTemp - inTemp);
                    arq.close();
                } catch (IOException e) {
                    System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
                }
            }
            System.out.printf("\nTempo Médio: %.3f m/s\n", ((somaParciais / 10) / 1000d));
        }
    }
}
