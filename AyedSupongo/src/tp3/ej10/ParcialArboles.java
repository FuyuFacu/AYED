package tp3.ej10;

import tp3.ej1.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class ParcialArboles {

    // Crear una lista para guardar el mejor camino (solo los 1)
// Recorrer el árbol desde la raíz, manteniendo:
//   - el camino actual
//   - el nivel actual
//   - el valor acumulado (nodo * nivel)
// En cada hoja:
//   - Si el valor acumulado es mayor al máximo, actualizar:
//       - el mejor valor
//       - la mejor lista (solo los 1 del camino actual)
// Devolver la mejor lista


    public static List<Integer> resolver(GeneralTree<Integer> arbol) {
        List<Integer> caminoActual = new ArrayList<>();
        List<Integer> caminoMaximo = new ArrayList<>();

        int[] maximo = { -1 };

        resolver(arbol, caminoActual, caminoMaximo, maximo, 0, 0);

        return caminoMaximo;
    }

    private static void resolver(GeneralTree<Integer> arbol, List<Integer> caminoActual,
                                 List<Integer> caminoMaximo, int[] maximo, int valorTotal, int nivel) {
        int datoActual = arbol.getData();
        if (datoActual == 1) {
            valorTotal += datoActual * nivel;
            caminoActual.add(datoActual);
        }

        if (!arbol.isLeaf()) {
            for (GeneralTree<Integer> hijo : arbol.getChildren()) {
                resolver(hijo, caminoActual, caminoMaximo, maximo, valorTotal, nivel + 1);
            }
        } else if (valorTotal > maximo[0]) {
            maximo[0] = valorTotal;
            valorTotal = 0;
            caminoMaximo.removeAll(caminoMaximo);
            caminoMaximo.addAll(caminoActual);
        }

        if (datoActual == 1) caminoActual.remove(caminoActual.size()-1);

    }

}
