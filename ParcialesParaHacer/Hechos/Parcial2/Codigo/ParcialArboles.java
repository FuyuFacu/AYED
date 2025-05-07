package org.example.Parcial2;

import org.example.practica1Ej8.GeneralTree;
import org.example.practica1Ej8.Queue;
import java.util.*;

public class ParcialArboles {
    GeneralTree<Integer> ab;

    public ParcialArboles(GeneralTree<Integer> ab) {
        this.ab = ab;
    }

    // El metodo debe devolver los nodos del nivel en donde cada nodo tenga al menos
    // la cantidad num de hijos.
    // Debe retornar el primer nivel que encuentre que cumple la condicion.
    // En caso de no encontrar ninguno retornar lista vacia

    public List<Integer> nivel(int num) {
        List<Integer> resultado = new ArrayList<>();

        return nivelRecorrido(ab, resultado, num);
    }

    public static List<Integer> nivelRecorrido(GeneralTree<Integer> ab, List<Integer> resultado, int num) {
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(ab);

        while (!cola.isEmpty()) {
            int act = cola.size();
            List<Integer> nivelActual = new ArrayList<>();
            boolean todosCumplen = true;

            for (int i = 0; i < act; i++) {
                GeneralTree<Integer> nodo = cola.dequeue();

                // Agregamos el dato al nivel actual
                nivelActual.add(nodo.getData());

                // Verificamos la condicion de los hijos
                if (nodo.getChildren().size() < num) todosCumplen = false;


                // Encolamos los hijos
                for (GeneralTree<Integer> child : nodo.getChildren()) {
                    cola.enqueue(child);
                }
            }
            if (todosCumplen) return nivelActual;
        }

        return new ArrayList<>();
    }


}
