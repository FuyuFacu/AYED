package tp2.ejercicio5;

import tp2.ejercicio1Y2.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> ab;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> ab) {
        this.ab = ab;
    }

    public int sumaElementosProfundidad(int n) {
        if (ab.isEmpty() || n < 0 ) return 0;
        int suma = 0;
        Queue<BinaryTree<Integer>> cola = new LinkedList<>();
        cola.add(ab);
        int nivelActual = 0;
        while(!cola.isEmpty()) {
            int nodoNivel = cola.size();
            if(nivelActual == n) {
                for(int i=0; i < nodoNivel; i++) {
                    BinaryTree<Integer> nodo = cola.remove();
                    suma += nodo.getData();
                    if(nodo.hasLeftChild()) cola.add(nodo.getLeftChild());
                    if(nodo.hasRightChild()) cola.add(nodo.getRightChild());
                }
            } else {
                for (int i = 0; i < nodoNivel; i++) {
                    BinaryTree<Integer> nodo = cola.remove();
                    if(nodo.hasLeftChild()) cola.add(nodo.getLeftChild());
                    if(nodo.hasRightChild()) cola.add(nodo.getRightChild());
                }

            }
            nivelActual++;
        }
        return suma;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(40);
        BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
        hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
        hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
        BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(78);
        arbol.addLeftChild(hijoIzquierdo);
        arbol.addRightChild(hijoDerecho);
        ProfundidadDeArbolBinario p = new ProfundidadDeArbolBinario(arbol);

        System.out.println("" + p.sumaElementosProfundidad(1));

    }
}
