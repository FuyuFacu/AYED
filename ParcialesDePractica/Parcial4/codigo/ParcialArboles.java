package org.example.Parcial3;

import org.example.practica1Ej8.BinaryTree;
import org.example.practica1Ej8.GeneralTree;
import org.example.practica1Ej8.Queue;
import java.util.*;



// El metodo debe devolver un nuevo arbol construido como:
// Si el arbol dado tiene hijo izq, nuevo arbol tendra hijo izq cuyo valor es suma de =
// (valor hijo izq + valor padre del arbol dado)
// Si arbol dado no tiene hijo izq, tampoco lo tendra el nuevo
// Hijos derehcos del nuevo arbol son iguales que los del arbol dado
// Hojas del arbol dado seran hojas en el nuevo



public class ParcialArboles {
    BinaryTree<Integer> ab;

    public BinaryTree<Integer> nuevoTree() {
        return nuevoTreeRec(ab, 0);
    }

    public BinaryTree<Integer> nuevoTreeRec(BinaryTree<Integer> ab, int valorPadre) {
        // Definimos los casos base
        if (ab == null) return null;

        int nuevoValor = ab.getData();

        BinaryTree<Integer> nuevoNodo = new BinaryTree<>(nuevoValor);

        if (ab.hasLeftChild()) {
            int suma = ab.getData() + ab.getLeftChild().getData();

            nuevoNodo.addLeftChild(nuevoTreeRec(ab.getLeftChild(), ab.getData()));
            nuevoNodo.getLeftChild().setData(suma);
        }

        if (ab.hasRightChild()) {
            nuevoNodo.addRightChild(nuevoTreeRec(ab.getRightChild(), ab.getData()));
        }

        return nuevoNodo;
    }




}
