/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mochila;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Backtrack.Problema;

/**
 *
 * @author tales
 */
public class carregarArquivo {

//    public MinhaMochila getConfig(String arq ) throws FileNotFoundException, IOException {
//        String s;
//
//        BufferedReader br = new BufferedReader(new FileReader( arq ));
//        s = br.readLine();
//        
//        ArrayList<Integer> itens = new ArrayList<Integer>();
//        ArrayList<Integer> peso = new ArrayList<Integer>();
//        
//        
//        int tamanho = Integer.parseInt(s);
//        for (int i = 0; i < tamanho ; i++) {            
//            s = br.readLine();
//        
//            String peso_ = s.split("    ")[1];
//            String iten_ = s.split("    ")[2];
//            peso_ = peso_.replace(" ", "");
//            iten_ = iten_.replace(" ", "");
//            System.out.println("["+peso_+"##"+iten_+"]");
//            
//            
//           peso.add( Integer.parseInt(peso_));
//           itens.add( Integer.parseInt(iten_));
//            
//            
//        }
//        s = br.readLine();
//        s = s.replace(" ", "");
//        
//        int capacidade = Integer.parseInt(s);
//        MinhaMochila mochila = new MinhaMochila(itens, peso, capacidade);
//        return mochila;
//        
//    }
    public Problema getConfig(String arq) throws FileNotFoundException, IOException {
        String s;
        BufferedReader br = new BufferedReader(new FileReader(arq));
        s = br.readLine();
        ArrayList<Integer> itens = new ArrayList<Integer>();
        ArrayList<Integer> peso = new ArrayList<Integer>();
        Pattern padrao = Pattern.compile("[0-9]+");
        Matcher pesquisa;
        int tamanho = Integer.parseInt(s);
        for (int i = 0; i < tamanho; i++) {
            s = br.readLine();
            String sq[] = s.split(" ");
            int contador = 0;
            for (int j = 0; j < sq.length; j++) {
                pesquisa = padrao.matcher(sq[j]);
                if (pesquisa.find()) {
                    if(contador == 1){
                        peso.add(Integer.parseInt(pesquisa.group()));                        
                    }
                    else if(contador == 2){
                        itens.add(Integer.parseInt(pesquisa.group()));
                    }                   
                     contador++;
                }
                
            }
        }
        s = br.readLine();
        pesquisa = padrao.matcher(s);
        pesquisa.find();
        int capacidade = Integer.parseInt(pesquisa.group());
        Problema mochila = new Problema(itens, peso, capacidade);
        return mochila;

    }

}
