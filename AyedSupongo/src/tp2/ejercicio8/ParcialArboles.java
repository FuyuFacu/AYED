package tp2.ejercicio8;


import tp1.ejercicio8.Queue;
import tp2.ejercicio1Y2.BinaryTree;

public class ParcialArboles {

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        // Si arbol1 esta vacio entonces es prefijo de cualquier arbol
        if (arbol1 == null) return true;

        // pero si el arbol2 esta vacio pero el 1 no pues retorna false 🗿🗿
        if (arbol2 == null) return false;

        // Hora de comparar datos. En este caso se compara que si son distintos los datos
        if (!arbol1.getData().equals(arbol2.getData())) return false;

        // Comparando subarboles
        boolean izquierda = true;
        boolean derecha = true;

        if (arbol1.hasLeftChild()) {
            if (!arbol2.hasLeftChild()) return false;
            izquierda = esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
        }

        if (arbol1.hasRightChild()) {
            if (!arbol2.hasRightChild()) return false;
            derecha = esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
        }

//      Si los dos son true, definitivamente confirmamos que arbol1 es prefijo de arbol 2
        return izquierda && derecha;

    }

}



//    Ta mal creo, mejor algo mas recursivo no creen?
//    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
//        return RecorridoNiveles(arbol1, arbol2);
//    }
//
//    private boolean RecorridoNiveles(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
//        Queue<BinaryTree<Integer>> colaArbol1 = new Queue<>();
//        Queue<BinaryTree<Integer>> colaArbol2 = new Queue<>();
//
//        colaArbol1.enqueue(arbol1);
//        colaArbol2.enqueue(arbol2);
//
//        colaArbol1.enqueue(null);
//        colaArbol2.enqueue(null);
//
//        while (!colaArbol1.isEmpty()) {
//            BinaryTree<Integer> nodoActualA1 = colaArbol1.dequeue();
//            BinaryTree<Integer> nodoActualA2 = colaArbol2.dequeue();
//            if (nodoActualA1 != null) {
//                if (nodoActualA1.getData() != nodoActualA2.getData()) {
//                    return false;
//                }
//
//                if (nodoActualA1.hasLeftChild()) colaArbol1.enqueue(nodoActualA1.getLeftChild());
//                if (nodoActualA1.hasRightChild()) colaArbol1.enqueue(nodoActualA1.getRightChild());
//
//                if (nodoActualA2.hasLeftChild()) colaArbol2.enqueue(nodoActualA2.getLeftChild());
//                if (nodoActualA2.hasRightChild()) colaArbol2.enqueue(nodoActualA2.getRightChild());
//
//            }else if (colaArbol2.isEmpty() ^ colaArbol1.isEmpty()) {
//                return false;
//            } else {
//                colaArbol1.enqueue(null);
//                colaArbol2.enqueue(null);
//            }
//
//        }
//        return true;
//    }
//


