/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mochila;

import Backtrack.Problema;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import sun.org.mozilla.javascript.internal.ast.ForInLoop;

/**
 *
 * @author tales
 */
public class Mochila {
    
    public static int[] solucao;
    /**
     * @param int capacidade é a capacidade total de carga da mochila
     * @param ArrayList<Integer> valorDosItens um array com os valores dos itens
     * @param ArrayList<Integer> pesoDosItens um array com os pesps dos itens
     *
     */
    public static MinhaMochila mochila(MinhaMochila m) {
        /*
         * @param int carga é a capacidade parcial de carga da mochila
         */
        int carga, valorTotal;
        carga = valorTotal = 0;
        int i = 1;
        System.out.println("Vetor de Peso: " + m.getPesos());
        System.out.println("Vetor de Itens: " + m.getValores());
        int ind = 0;
        ArrayList<ItensEscolhidos> escolhas = new ArrayList<ItensEscolhidos>();
        /**
         * Calcula a razao de todos os elementos dos vetores e salva em min, a
         * menor razao entre peso e custo e salva em ind o indice, apos a rodada
         * de calculo esse indice é removido dos vetores para nao ser
         * considerado
         */
        for (int k = 0; k < m.getValores().size(); k++) {
            double razao = m.getPesos().get(k).doubleValue() / m.getValores().get(k).doubleValue();
            //System.out.printf("Peso: %f Valor: %f razao: %f \n", pesoDosItens.get(k).doubleValue(),valorDosItens.get(k).doubleValue(), razao);
            escolhas.add(new ItensEscolhidos(k, razao));
        }
        Collections.sort(escolhas);
        ItensEscolhidos itenEscolhido = new ItensEscolhidos(0, 0);
        for (int j = 0; j < escolhas.size(); j++) {
            itenEscolhido = escolhas.get(j);
            ind = itenEscolhido.getIndice();
            if (m.getPesos().get(ind) <= (m.getCapacidade() - carga)) {
                carga += m.getPesos().get(ind);
                valorTotal += m.getValores().get(ind);
                System.out.println("carga: " + carga + " valor:" + valorTotal + " peso literal: " + m.getPesos().get(ind) + "  valor unitario: " + m.getValores().get(ind));
                m.getSaida().add(itenEscolhido.getIndice());
                m.getSaida().add(itenEscolhido.getIndice());
                m.getItensALevar().set(itenEscolhido.getIndice(), 1);
            }
        }
        System.out.println("Itens: "+m.getItensALevar());
        m.setSolucao("Guloso");
        m.setValor(valorTotal);
        m.setPesoTotal(carga);
        System.out.println(m.printSaida());
        return m;
    }
    public static MinhaMochila mochilaFracionaria(MinhaMochila m) {
        /*
         * @param int carga é a capacidade parcial de carga da mochila
         */
        int carga, valorTotal;
        carga = valorTotal = 0;
        int i = 1;
        System.out.println("Vetor de Peso: " + m.getPesos());
        System.out.println("Vetor de Itens: " + m.getValores());
        int ind = 0;
        ArrayList<ItensEscolhidos> escolhas = new ArrayList<ItensEscolhidos>();
        /**
         * Calcula a razao de todos os elementos dos vetores e salva em min, a
         * menor razao entre peso e custo e salva em ind o indice, apos a rodada
         * de calculo esse indice é removido dos vetores para nao ser
         * considerado
         */
        for (int k = 0; k < m.getValores().size(); k++) {
            double razao = m.getPesos().get(k).doubleValue() / m.getValores().get(k).doubleValue();
            //System.out.printf("Peso: %f Valor: %f razao: %f \n", pesoDosItens.get(k).doubleValue(),valorDosItens.get(k).doubleValue(), razao);
            escolhas.add(new ItensEscolhidos(k, razao));
        }
        Collections.sort(escolhas);
        ItensEscolhidos itenEscolhido = new ItensEscolhidos(0, 0);
        for (int j = 0; j < escolhas.size(); j++) {
            itenEscolhido = escolhas.get(j);
            ind = itenEscolhido.getIndice();
            if (m.getPesos().get(ind) <= (m.getCapacidade() - carga)) {
                carga += m.getPesos().get(ind);
                valorTotal += m.getValores().get(ind);
                System.out.println("carga: " + carga + " valor:" + valorTotal + " peso literal: " + m.getPesos().get(ind) + "  valor unitario: " + m.getValores().get(ind));
                m.getSaida().add(itenEscolhido.getIndice());
                m.getSaida().add(itenEscolhido.getIndice());
                m.getItensALevar().set(itenEscolhido.getIndice(), 1);
            }
            else{
                double novaCarga = 0;
                novaCarga = m.getCapacidade()-carga;
                novaCarga = novaCarga / m.getPesos().get(ind);
                double valorFracionario = novaCarga*m.getValores().get(ind);
                valorTotal += valorFracionario;
                m.getSaida().add(itenEscolhido.getIndice());
                m.getSaida().add(itenEscolhido.getIndice());
                m.getItensALevar().set(itenEscolhido.getIndice(), 1);
                
                break;
            }
        }
        System.out.println("Itens: "+m.getItensALevar());
        m.setSolucao("Guloso");
        m.setValor(valorTotal);
        m.setPesoTotal(carga);
        System.out.println(m.printSaida());
        return m;
    }

    /**
     * @param int capacidade é a capacidade total de carga da mochila
     * @param int[] tamanho é um vetor com os pesos de cada item
     * @param int[] lucro é um vetor com os valor de cada item
     * @param int[] lucroMaxCap é um vetor para memorizacao
     *
     */
    public static int mochilaProgramacaoDinamica(int capacidade, int[] tamanho, int ind, int lucro[], int[] lucroMaxCap) {
        int lucroMax = 0;
        if (lucroMaxCap[capacidade] > 0) {
            
            return lucroMaxCap[capacidade];
        } else {
            for (int i = ind; i < tamanho.length; i++) {
                int espaco = capacidade - tamanho[i];
                if (espaco >= 0) {
                    int lucroComItem = mochilaProgramacaoDinamica(espaco, tamanho, i+1, lucro, lucroMaxCap) + lucro[i];
                    if (lucroComItem > lucroMax) {
                        lucroMax = lucroComItem;
                    }
                }
            }
            lucroMaxCap[capacidade] = lucroMax;
            solucao[capacidade] = ind;
        }
        
        return lucroMax;
    }

    public static void exec(String arquivo) throws FileNotFoundException, IOException {
        System.out.println("####################################");
        System.out.println("Aqruivo: " + arquivo);
        carregarArquivo arq = new carregarArquivo();
        Problema mochila = arq.getConfig(arquivo);

        int[] itens = new int[mochila.getValores().size()];
        int[] pesos = new int[mochila.getPesos().size()];
        int[] memo = new int[mochila.getCapacidade() + 1];
        for (int i = 0; i < mochila.getPesos().size(); i++) {
            mochila.getPesos().size();
            itens[i] = mochila.getValores().get(i);
            pesos[i] = mochila.getPesos().get(i);

        }
        for (int i = 0; i <= mochila.getCapacidade(); i++) {
            memo[i] = 0;
        }
       // solucao = new int[mochila.getCapacidade()+1];
        //System.out.println( "Valor máximo aproximado PD: "+ mochilaProgramacaoDinamica( mochila.getCapacidade(), itens,0, pesos,memo));
       // for (int i = 0; i <= solucao.length; i++) {
       //     if( solucao[i] > 0)
       //         System.out.println("i: "+i+", "+solucao[i]);
            
       // }

        mochila = (Problema)mochilaFracionaria(mochila);
        BacktrackMochila bt = new BacktrackMochila();
        ArrayList<Integer> s = new ArrayList<Integer>();
        for (int i = 0; i < mochila.getPesos().size() ; i++) {
            s.add(-1);
        }
        
        //bt.BTDec(s, 0, mochila);
        //System.out.println("Solucao: "+bt.getSolucao());

        //mochila.GravaSaida(arquivo+".out");
        ///System.out.println("Valor máximo aproximado GULOSO: " + mochila.getValor());
        System.out.println("####################################");
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String arq[] = {"src/arquivos/test_10_1.in", "src/arquivos/test_10_2.in", "src/arquivos/test_10_3.in", "src/arquivos/test_10_4.in",
            "src/arquivos/test_20_1.in", "src/arquivos/test_20_2.in", "src/arquivos/test_20_3.in", "src/arquivos/test_20_4.in",};
        //for (int i = 0; i < arq.length ; i++) {
            exec(arq[0]);

        //}
    }
}
