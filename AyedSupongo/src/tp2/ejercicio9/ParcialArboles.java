package tp2.ejercicio9;

import tp1.ejercicio8.Queue;
import tp2.ejercicio1Y2.BinaryTree;

public class ParcialArboles {

    public BinaryTree<Par> sumAndDif(BinaryTree<Integer> ab) {
        return construir(ab, 0, 0);
    }

    private BinaryTree<Par> construir(BinaryTree<Integer> nodo, int sumaHastaPadre, int valorPadre) {
        if (nodo == null) return null;

        int valorActual = nodo.getData();
        int nuevaSuma = sumaHastaPadre + valorActual;
        int diferencia = valorActual - valorPadre;

        BinaryTree<Par> nuevoNodo = new BinaryTree<>(new Par(nuevaSuma, diferencia));
        if (nodo.hasLeftChild()) nuevoNodo.addLeftChild(construir(nodo.getLeftChild(), nuevaSuma, valorActual));
        if (nodo.hasRightChild()) nuevoNodo.addRightChild(construir(nodo.getRightChild(), nuevaSuma, valorActual));

        return nuevoNodo;
    }

    public static void printLevelOrder(BinaryTree<Par> root) {
        if (root == null) return;

        Queue<BinaryTree<Par>> queue = new Queue<>();
        queue.enqueue(root);
        queue.enqueue(null); // marcador de fin de nivel

        while (!queue.isEmpty()) {
            BinaryTree<Par> current = queue.dequeue();
            if (current != null) {
                System.out.print(current.getData() + " ");
                if (current.hasLeftChild()) queue.enqueue(current.getLeftChild());
                if (current.hasRightChild()) queue.enqueue(current.getRightChild());
            } else {
                System.out.println(); // salto de línea al finalizar un nivel
                if (!queue.isEmpty()) {
                    queue.enqueue(null); // volver a marcar fin de nivel
                }
            }
        }
    }


    public static void main(String[] args) {
        // Construimos el árbol original:
        //        5
        //       / \
        //     10   20
        //    /
        //   3

        BinaryTree<Integer> arbol = new BinaryTree<>(5);
        BinaryTree<Integer> nodo10 = new BinaryTree<>(10);
        BinaryTree<Integer> nodo20 = new BinaryTree<>(20);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(3);

        arbol.addLeftChild(nodo10);
        arbol.addRightChild(nodo20);
        nodo10.addLeftChild(nodo3);

        // Aplicar sumAndDif
        ParcialArboles parcial = new ParcialArboles();
        BinaryTree<Par> resultado = parcial.sumAndDif(arbol);

        // Imprimir el árbol resultante por niveles
        printLevelOrder(resultado);
    }




}
