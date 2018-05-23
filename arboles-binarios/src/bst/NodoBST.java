package bst;

public class NodoBST<TipoDeDato extends Comparable<TipoDeDato>> implements java.lang.Comparable<TipoDeDato> {

    TipoDeDato dato;
    NodoBST<TipoDeDato> hijoIzquierdo;
    NodoBST<TipoDeDato> hijoDerecho;

    /*public NodoBST() {
        dato = null;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }*/

    public NodoBST(TipoDeDato valor) {
        dato = valor;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }

    public NodoBST(TipoDeDato valor, NodoBST<TipoDeDato> hijoIzq, NodoBST<TipoDeDato> hijoDer) {
        dato = valor;
        hijoIzquierdo = hijoIzq;
        hijoDerecho = hijoDer;
    }

    public TipoDeDato getDato() {
        return dato;
    }

    public void setDato(TipoDeDato dato) {
        this.dato = dato;
    }

    public NodoBST<TipoDeDato> getIzquierda() {
        return hijoIzquierdo;
    }

    public void setIzquierda(NodoBST<TipoDeDato> izquierda) {
        this.hijoIzquierdo = izquierda;
    }

    public NodoBST<TipoDeDato> getDerecha() {
        return hijoDerecho;
    }

    public void setDerecha(NodoBST<TipoDeDato> derecha) {
        this.hijoDerecho = derecha;
    }

    @Override
    public int compareTo(TipoDeDato o) {
        return dato.compareTo(o);
    }
}
