package org.example;

import org.example.practica1Ej8.GeneralTree;
import org.example.practica1Ej8.Queue;

import java.util.List;



public class ComparadorDeArbolesGenerales2 {

    // Un arbol general arbol1 se considera "Profundamente inferior" a otro arbol general arbol2
    // Cuando se cumplen las siguientes dos reglas en todos los nodos coindicentes
    // En posicion de ambos arboles:

    // 1- El valor de cada nodo en arbol1 debe ser menor que el valor del nodo correspondiente en
    // arbol2

    // 2- a) Si ambos nodos tienen hijos, la suma de los valores de los hijos de cada nodo en arbol1
    // debe ser menor que la suma de los valores de los hijos del nodo correspondiente en arbol2

    // b) Si ambos nodos son hojas: La condicion se considera cumplida para esos nodos si se cumple
    // La condicion 1

    // Si uno de los nodos es hoja y otro no:
    // c1) Si un nodo de arbol1 es hoja y el nodo correspondiente en arbol2 no,
    // entonces la condicion se considera cumplida para ese nodo si se cumple la condicion 1
    // c2) Si un nodo de arbol1 no es hoja y el nodo correspondiente en arbol2 es hoja, entonces arbol1
    // NO es "profundamente inferior", y el metodo debe devolver false


    public boolean esInferiorProfundo(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2) {
        GeneralTree<Integer> nodo1 = arbol1;
        GeneralTree<Integer> nodo2 = arbol2;

        // Definir los casos base
        // Condicion 1
        if (nodo1.getData() > nodo2.getData()) return false;

        boolean tieneHijos1 = arbol1.hasChildren();
        boolean tieneHijos2 = arbol2.hasChildren();

        if (tieneHijos1 && tieneHijos2) {
            List<GeneralTree<Integer>> hijos1 = arbol1.getChildren();
            List<GeneralTree<Integer>> hijos2 = arbol2.getChildren();

            int suma1 = 0;
            int suma2 = 0;
            for (GeneralTree<Integer> child : hijos1) suma1 += child.getData();
            for (GeneralTree<Integer> child : hijos2) suma2 += child.getData();

            if (suma1 >= suma2) return false;

            int minSize = Math.min(hijos1.size(), hijos2.size());
            for (int i = 0; i < minSize; i++) {
                if (!esInferiorProfundo(hijos1.get(i), hijos2.get(i))) return false;
            }
        }
        if (!nodo1.isLeaf() && nodo2.isLeaf()) return false;

        return true;
    }



}
