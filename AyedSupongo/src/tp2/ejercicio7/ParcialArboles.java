package tp2.ejercicio7;

import tp1.ejercicio8.Queue;
import tp2.ejercicio1Y2.BinaryTree;

public class ParcialArboles {
    private BinaryTree<Integer> ab;

    public ParcialArboles(BinaryTree<Integer> ab) {
        this.ab = ab;
    }


    public boolean isLeftTree(int num) {
        //Si el árbol con raíz "num" no cuenta con una de sus ramas, considere que en esa rama hay -1 árboles con único hijo
        int arbIzq = -1;
        int arbDer = -1;

        BinaryTree<Integer> nodoRaiz = EncontrarNodo(num);

        if (nodoRaiz != null) {
            if (nodoRaiz.hasLeftChild()) arbIzq = CantidadSubarboles(nodoRaiz.getLeftChild());
            if (nodoRaiz.hasRightChild()) arbDer = CantidadSubarboles(nodoRaiz.getRightChild());
        }

        return (arbIzq > arbDer);
    }


    private BinaryTree<Integer> EncontrarNodo(int valorRaiz) {
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        cola.enqueue(this.ab);

        while (!cola.isEmpty()) {
            BinaryTree<Integer> nodoActual = cola.dequeue();
                if (nodoActual.getData() == valorRaiz) {
                    return nodoActual;
                }
                if (nodoActual.hasLeftChild()) cola.enqueue(nodoActual.getLeftChild());
                if (nodoActual.hasRightChild()) cola.enqueue(nodoActual.getRightChild());

        }
        // Si no lo encontro devuelve null xd
        return null;
    }
//            if (nodoActual != null) { y
//            else if (!cola.isEmpty()) cola.enqueue(null); no los implemento por que no me interesa buscar
//            por niveles,
//            simplemente quiero encontrar mi maldito nodo kjj
        // Si no lo encontro devuelve null xd



    private int CantidadSubarboles(BinaryTree<Integer> arbol) {
        int cantidad = 0;

        if (!arbol.isLeaf()) {
            boolean tieneIzq = arbol.hasLeftChild();
            boolean tieneDer = arbol.hasRightChild();


            if (tieneIzq ^ tieneDer) cantidad++;

//           este metodo tambien es valido, simplemente recordé que
//           se puede usar XOR para este caso, ya que solo es true
//           si solo uno de los parametros es true:

//           if ((tieneIzq && !tieneDer) || (!tieneIzq && tieneDer))
//               cantidad++;

            //Siempre sigo recorriendo
            if (tieneDer) cantidad += CantidadSubarboles(arbol.getRightChild());
            if (tieneIzq) cantidad += CantidadSubarboles(arbol.getLeftChild());

        }

        return cantidad;
    }

    public static void main(String[] args) {
        // Crear árbol manualmente
        //        10
        //       /  \
        //      5    15
        //     /      \
        //    3        20
        //             /
        //           17

        BinaryTree<Integer> raiz = new BinaryTree<>(10);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo15 = new BinaryTree<>(15);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
        BinaryTree<Integer> nodo20 = new BinaryTree<>(20);
        BinaryTree<Integer> nodo17 = new BinaryTree<>(17);

        // Armar árbol
        raiz.addLeftChild(nodo5);
        raiz.addRightChild(nodo15);

        nodo5.addLeftChild(nodo3);
        nodo15.addRightChild(nodo20);

        nodo20.addLeftChild(nodo17);

        // Crear instancia de ParcialArboles
        ParcialArboles parcial = new ParcialArboles(raiz);

        // Probar con el nodo 10 como raíz
        boolean resultado = parcial.isLeftTree(10);
        System.out.println("El lado izquierdo del nodo 10 tiene mas nodos con un solo hijo que el derecho? " + resultado);

        // Probar con otro nodo como raíz
        boolean resultado2 = parcial.isLeftTree(15);
        System.out.println("El lado izquierdo del nodo 15 tiene mas nodos con un solo hijo que el derecho? " + resultado2);


    }


}
