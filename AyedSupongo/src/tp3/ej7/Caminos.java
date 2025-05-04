package tp3.ej7;

import tp3.ej1.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class Caminos {

    GeneralTree<Integer> arbol;

    public Caminos(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public List<Integer> caminoAHojaMasLejana() {
        if (arbol == null || arbol.isEmpty()) return new ArrayList<>();
        return caminoMasLargoDesde(arbol);
    }

    private List<Integer> caminoMasLargoDesde(GeneralTree<Integer> nodo) {
        List<Integer> caminoMax = new ArrayList<>();

        // Si es hoja, el camino es solo ese nodo
        if (nodo.isLeaf()) {
            caminoMax.add(nodo.getData());
            return caminoMax;
        }

        // Recorro hijos y busco el camino más largo
        for (GeneralTree<Integer> hijo : nodo.getChildren()) {
            List<Integer> caminoHijo = caminoMasLargoDesde(hijo);
            if (caminoHijo.size() > caminoMax.size()) {
                caminoMax = caminoHijo;
            }
        }

        // Agrego el nodo actual al inicio del camino
        caminoMax.add(0, nodo.getData());
        return caminoMax;
    }
}


