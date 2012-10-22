/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Backtrack;

import java.util.ArrayList;

/**
 *
 * @author tales
 */
public abstract class GenericBackTrack {
    private ArrayList<Integer> solucao = new ArrayList<Integer>();

    public ArrayList<Integer> getSolucao() {
        return solucao;
    }
    
    
    public GenericBackTrack() {
    }
    
    public void BTDec(ArrayList<Integer> s, int i, Problema problema) {
        if (isComplete(s, problema)) {
            if (isConsistente(s, problema)) {
                if (objetivo(s, problema) > objetivo(solucao, problema)) {
                    solucao = new ArrayList<Integer>(s);
                }
            }
            return;
        }
        int j = 0;//problema.D[i].inicio;
        while (j <= 1) {
            s.set(i, j);
            if (isConsistente(s, problema)) {
                BTDec(s, i + 1, problema);
            }
            s.set(i, -1);
            j++;
        }
    }

    public abstract boolean isComplete(ArrayList<Integer> s, Problema problema);

    public abstract boolean isConsistente(ArrayList<Integer> s, Problema problema);

    public abstract int objetivo(ArrayList<Integer> s, Problema problema);
}
