/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mochila;

/**
 *
 * @author tales
 */
public class ItensEscolhidos implements Comparable<ItensEscolhidos> {
    private int indice;
    private double valor;

    public ItensEscolhidos(int indice, double valor) {
        this.indice = indice;
        this.valor = valor;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItensEscolhidos other = (ItensEscolhidos) obj;
        if (this.indice != other.indice) {
            return false;
        }
        if (this.valor != other.valor) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(ItensEscolhidos o) {
        if (this.valor < o.getValor())
                return -1;
        else if (this.valor == o.getValor())
                return 0;
        return 1;
    }

    @Override
    public String toString() {
        return "ItensEscolhidos{" + "indice=" + indice + ", valor=" + valor + "}\n";
    }

    
    
}
