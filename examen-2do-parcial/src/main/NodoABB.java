package main;

public class NodoABB <TipoDeDato extends Comparable<TipoDeDato>> implements java.lang.Comparable<TipoDeDato> {

    TipoDeDato dato;
    NodoABB<TipoDeDato> hijoIzquierdo;
    NodoABB<TipoDeDato> hijoDerecho;

    public NodoABB() {
        dato = null;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }

    public NodoABB(TipoDeDato valor) {
        dato = valor;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }

    public NodoABB(TipoDeDato valor, NodoABB<TipoDeDato> hijoIzq, NodoABB<TipoDeDato> hijoDer) {
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

    public NodoABB<TipoDeDato> getIzquierda() {
        return hijoIzquierdo;
    }

    public void setIzquierda(NodoABB<TipoDeDato> izquierda) {
        this.hijoIzquierdo = izquierda;
    }

    public NodoABB<TipoDeDato> getDerecha() {
        return hijoDerecho;
    }

    public void setDerecha(NodoABB<TipoDeDato> derecha) {
        this.hijoDerecho = derecha;
    }

    @Override
    public int compareTo(TipoDeDato o) {
        return dato.compareTo(o);
    }
}
