package org.example.ParcialesFranja.ParcialSuma;

import org.example.practica1Ej8.BinaryTree;

public class Parcial {


    public Integer sumaImparesPosOrdenMayorA(BinaryTree<Integer> ab, int limite) {
        if (ab == null || ab.isEmpty()) return 0;

        int total = 0;

        // PosOrden es subArbol izquierdo, subArbol derecho, y por ulitmo el nodo
        // Hacer bien la implementacion sino puede restarme varios puntos

        if (ab.hasLeftChild()) total += sumaImparesPosOrdenMayorA(ab.getLeftChild(), limite);
        if (ab.hasRightChild()) total += sumaImparesPosOrdenMayorA(ab.getRightChild(), limite);

        if (ab.getData() > limite && ab.getData() % 2 != 0) {
            total += ab.getData();
        }


        return total;

    }

}
