/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mochila;

import Backtrack.Problema;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author tales
 */
public class MinhaMochila {
    private ArrayList<Integer> valores;
    private ArrayList<Integer> pesos;
    private ArrayList<Integer> saida = new ArrayList<Integer>();
    private ArrayList<Integer> itensALevar = new ArrayList<Integer>();
    private String solucao;
    private int valor;
    private int pesoTotal;

    public MinhaMochila() {
    }

    
    public int getPesoTotal() {
        return pesoTotal;
    }

    public ArrayList<Integer> getSaida() {
        return saida;
    }

    public void setSaida(ArrayList<Integer> saida) {
        this.saida = saida;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }
    private int capacidade;

    public MinhaMochila(int capacidade) {
        this.capacidade = capacidade;
    }

    public MinhaMochila(ArrayList<Integer> itens, ArrayList<Integer> pesos, int capacidade) {
        this.valores = itens;
        this.pesos = pesos;
        this.capacidade = capacidade;
        for (int i = 0; i < pesos.size(); i++) {
            itensALevar.add(0);            
        }
    }

    public ArrayList<Integer> getItensALevar() {
        return itensALevar;
    }

    public void setItensALevar(ArrayList<Integer> itensALevar) {
        this.itensALevar = itensALevar;
    }

    

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public ArrayList<Integer> getValores() {
        return valores;
    }

    public void setValores(ArrayList<Integer> itens) {
        this.valores = itens;
    }

    public ArrayList<Integer> getPesos() {
        return pesos;
    }

    public void setPesos(ArrayList<Integer> pesos) {
        this.pesos = pesos;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    void setPesoTotal(int carga) {
        this.pesoTotal = carga;
    }
    
    public String printSaida(){
        String saida;
        saida = this.pesos.size()+"\n";
        for (int i = 0; i < this.pesos.size(); i++) {
           saida += i+"\t"+pesos.get(i)+"\t"+valores.get(i)+"\n";
        }
        saida += capacidade+"\n";
        saida += solucao+"\n";
        for (int i = 0; i < this.saida.size(); i++) {
           saida += this.saida.get(i)+"\t";
        }
        saida += "\n"+valor+"\n";
        return saida;
    }
    public void GravaSaida( String saida) throws IOException{
        FileWriter f = new FileWriter( saida,true );
        f.write( this.printSaida() );
        f.close();
    }

    
    
    
}
