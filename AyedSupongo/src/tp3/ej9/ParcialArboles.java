package tp3.ej9;

import tp3.ej1.GeneralTree;

import java.util.List;

public class ParcialArboles {


    // Ok lo que tengo que hacer con esto es ->
    // Si el nodo no tiene hijos -> true
    // Sino:
    //   Buscar el menor entre sus hijos
    //   Compararlo con el nodo actual
    //   Si son iguales entonces retorna ture
    //   Si no, no cumple
    //   Ademas, se requiere revisar que los demas hijos cumplan

    public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
        boolean respuesta = true;
        return cumpleSeleccion(arbol);
    }


    public static boolean cumpleSeleccion(GeneralTree<Integer> arbol) {
        if (arbol.isLeaf()) return true;

        List<GeneralTree<Integer>> hijos = arbol.getChildren();

        int menor = Integer.MAX_VALUE;
        for (GeneralTree<Integer> hijo : hijos) {
            if (!cumpleSeleccion(hijo)) return false;
            if (hijo.getData() < menor) menor = hijo.getData();

        }
        return (menor == arbol.getData());

    }

}
