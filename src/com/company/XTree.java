package com.company;

import java.util.ArrayList;

public class XTree {
    private String nodo;
    private XTree[] filhos;
    private int[] valores;
    private int alturaMaxima = 0;
    private int somaTotal = 0;

    public XTree() {

    }

    public XTree(String n, ArrayList<String> lista) {
        this.nodo = n;
        this.filhos = new XTree[Integer.parseInt(lista.get(0))];
        lista.remove(0);
        this.valores = new int[Integer.parseInt(lista.get(0))];
        lista.remove(0);
        String[] altura = n.split("\\.");
        this.alturaMaxima = altura.length;
        for(int i=0; i<this.filhos.length; i++) {
            this.filhos[i] = new XTree(n+"."+(i+1), lista);
            setAlturaMaxima(this.filhos[i].getAlturaMaxima());
            this.somaTotal = this.filhos[i].somaTotal + this.somaTotal;
        }
        setAddFilhos(lista);
    }

    public void setAddFilhos(ArrayList<String> lista) {
        for (int i = 0; i<this.valores.length; i++) {
            this.valores[i] = Integer.parseInt(lista.get(0));
            this.somaTotal = this.somaTotal + Integer.parseInt(lista.get(0));
            lista.remove(0);
        }
    }

    public void printNodo() {
        String val = "";
        for (int n: valores) {
            val = val + " " + n;
        }
        System.out.printf("Nodo: %s | Filhos: %d | Valores[%d]:%s\n", this.nodo, this.filhos.length, this.valores.length, val);
        for(XTree x: filhos) {
            x.printNodo();
        }
    }

    public int getSomaTotal() {
        return this.somaTotal;
    }

    public int getAlturaMaxima() {
        return this.alturaMaxima;
    }

    public void setAlturaMaxima(int alt) {
        if (alt > this.alturaMaxima) this.alturaMaxima = alt;
    }
}
