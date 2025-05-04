package tp3.ej11;

import tp3.ej1.GeneralTree;
import tp1.ejercicio8.Queue;

public class ParcialArboles {

    public static boolean resolver(GeneralTree<Integer> arbol) {
        if (arbol == null) return false;

        Queue<GeneralTree<Integer>> cola = new Queue<>();

        cola.enqueue(arbol);

        int nivel = 0;
        while (!cola.isEmpty()) {
            int nodosNivel = cola.size();
            if (nodosNivel != nivel + 1) return false;

            for (int i = 0; i < nodosNivel; i++) {
                GeneralTree<Integer> nodo = cola.dequeue();
                for (GeneralTree<Integer> hijo : nodo.getChildren()) {
                    cola.enqueue(hijo);
                }
            }
            nivel++;
        }

        return true;
    }
}
