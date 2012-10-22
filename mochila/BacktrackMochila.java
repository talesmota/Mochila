/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mochila;

import Backtrack.GenericBackTrack;
import Backtrack.Problema;
import java.util.ArrayList;

/**
 *
 * @author tales
 */
public class BacktrackMochila extends GenericBackTrack {

    public BacktrackMochila() {
    }
    
    

    @Override
    public boolean isComplete(ArrayList<Integer> s, Problema problema) {
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isConsistente(ArrayList<Integer> s, Problema problema) {
         int pesoTotal = 0;
        for (int i = 0; i < s.size(); i++) {
            if (pesoTotal <= problema.getCapacidade()) {
                if (s.get(i) == 1) {
                    pesoTotal += problema.getPesos().get(i);
                }
            } else {
                return false;
            }

        }
        return true;
    }

    @Override
    public int objetivo(ArrayList<Integer> s, Problema problema) {
        int valorTotal = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) == 1) {
                valorTotal += problema.getValores().get(i);
            }
        }
        return valorTotal;
    }

    }
