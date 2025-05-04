package tp3.ej4;

import tp1.ejercicio8.Queue;
import tp3.ej1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class AnalizadorArbol {


    public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
        double mayorPromedio = -1;
        int contador = 0;
        GeneralTree<AreaEmpresa> aux;
        Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>();
        queue.enqueue(arbol);
        queue.enqueue(null);
        double acumulador = 0;
        while (!queue.isEmpty()) {
            aux = queue.dequeue();
            if (aux != null) {
                contador++;
                acumulador += aux.getData().getTardanzaMensaje();

                for (GeneralTree<AreaEmpresa> child : aux.getChildren()) {
                    queue.enqueue(child);
                }
            } else {
                double promedio = acumulador / contador;
                if (promedio > mayorPromedio) mayorPromedio = promedio;

                acumulador = 0;
                contador = 0;

                if (!queue.isEmpty()) {
                    queue.enqueue(null); // Marca el próximo nivel
                }
            }

        }
        return mayorPromedio;
    }




}