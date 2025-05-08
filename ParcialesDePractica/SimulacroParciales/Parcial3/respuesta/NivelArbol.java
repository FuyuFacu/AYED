package org.example.ParcialesFranja.ParcialNiveles;

import org.example.practica1Ej8.BinaryTree;
import org.example.practica1Ej8.Queue;

import java.util.LinkedList;


public class NivelArbol {
    BinaryTree<Integer> ab;

    public NivelArbol(BinaryTree<Integer> ab) {
        this.ab = ab;
    }

    public BinaryTree<Integer> minEnNivelAB(int n) {
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        cola.enqueue(ab);
        cola.enqueue(null);

        BinaryTree<Integer> nodo = new BinaryTree<>();
        BinaryTree<Integer> nodoMinimo = null;

        int nodoMinimoInt = Integer.MAX_VALUE;
        int nivelActual = 0;
        while (!cola.isEmpty()) {

            nodo = cola.dequeue();

            if (nodo != null) {

                if (nodo.isLeaf()) {
                    if (nodo.getData() < nodoMinimoInt ) {
                        nodoMinimoInt = nodo.getData();
                        nodoMinimo = nodo;
                    }
                }


                if (nodo.hasLeftChild()) cola.enqueue(nodo.getLeftChild());
                if (nodo.hasRightChild()) cola.enqueue(nodo.getRightChild());

            } else {
                if (nivelActual == n) {
                    return nodoMinimo;
                } else {
                    nivelActual++;
                    nodoMinimoInt = Integer.MAX_VALUE;
                    nodoMinimo = null;

                    if (!cola.isEmpty()) {
                        cola.enqueue(null);
                    }
                }
            }

        }
        return null;
    }

}
