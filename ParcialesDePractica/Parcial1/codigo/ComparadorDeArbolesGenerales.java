package org.example;

import org.example.practica1Ej8.GeneralTree;
import org.example.practica1Ej8.Queue;

import java.util.List;


public class ComparadorDeArbolesGenerales
{

    // Un arbol general arbol1 se considera "Profundamente inferior" a otro arbol general arbol2
    // Cuando se cumplen las siguientes dos reglas en todos los nodos coindicentes
    // En posicion de ambos arboles:

    // 1- El valor de cada nodo en arbol1 debe ser menor que el valor del nodo correspondiente en
    // arbol2

    // 2- a) Si ambos nodos tienen hijos, la suma de los valores de los hijos de cada nodo en arbol1
    // debe ser menor que la suma de lso valores de los hijos del nodo correspondiente en arbol2

    // b) Si ambos nodos son hojas: La condicion se considera cumplida para esos nodos si se cumple
    // La condicion 1

    // Si uno de los nodos es hoja y otro no:
    // c1) Si un nodo de arbol1 es hoja y el nodo correspondiente en arbol2 no,
    // entonces la condicion se considera cumplida para ese nodo si se cumple la condicion 1
    // c2) Si un nodo de arbol1 no es hoja y el nodo correspondiente en arbol2 es hoja, entonces arbol1
    // NO es "profundamente inferior", y el metodo debe devolver false

    public int SumaHijos(List<GeneralTree<Integer>> hijos) {
        int total = 0;
        for (GeneralTree<Integer> hijo : hijos) {
            total += hijo.getData();
        }

        return total;
    }


    public boolean esInferiorProfundo(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2) {
        Queue<GeneralTree<Integer>> cola1 = new Queue<>();
        Queue<GeneralTree<Integer>> cola2 = new Queue<>();

        cola1.enqueue(arbol1);
        cola2.enqueue(arbol2);

        while (!cola1.isEmpty() && !cola2.isEmpty()) {
            GeneralTree<Integer> nodo1 = cola1.dequeue();
            GeneralTree<Integer> nodo2 = cola2.dequeue();

            if (nodo1.getData() >= nodo2.getData()) return false;

            boolean esHoja1 = nodo1.isLeaf();
            boolean esHoja2 = nodo2.isLeaf();

            // Los árboles deben tener la misma estructura para comparar nodos en la misma posición
            if (!esHoja1 && esHoja2) return false;

            if (!(esHoja1 && esHoja2)) {
                int suma1 = SumaHijos(nodo1.getChildren());
                int suma2 = SumaHijos(nodo2.getChildren());
                if (suma1 >= suma2) return false;


                List<GeneralTree<Integer>> hijos1 = nodo1.getChildren();
                List<GeneralTree<Integer>> hijos2 = nodo2.getChildren();
                if (hijos1.size() != hijos2.size()) return false;

                for (int i = 0; i < hijos1.size(); i++) {
                    cola1.enqueue(hijos1.get(i));
                    cola2.enqueue(hijos2.get(i));
                }

            }

        }

        return cola1.isEmpty() && cola2.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
