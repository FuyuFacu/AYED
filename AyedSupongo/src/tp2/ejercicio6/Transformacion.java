package tp2.ejercicio6;

import tp2.ejercicio1Y2.BinaryTree;

public class Transformacion {
    private BinaryTree<Integer> ab;

    public Transformacion(BinaryTree<Integer> ab) {
        this.ab = ab;
    }
//    public BinaryTree<Integer> suma(BinaryTree<Integer> ab) {
//        if (ab == null) return null;
//        BinaryTree<Integer> izq = null;
//        BinaryTree<Integer> der = null;
//        int sumaIzq = 0;
//        int sumaDer = 0;
//
//        if (ab.hasLeftChild()) {
//            izq = suma(ab.getLeftChild());
//            sumaIzq = izq.getData();
//        }
//        if (ab.hasRightChild()) {
//            der = suma(ab.getRightChild());
//            sumaDer = der.getData();
//        }
//
//        BinaryTree<Integer> nuevo = new BinaryTree<>(sumaIzq + sumaDer);
//        nuevo.addLeftChild(izq);
//        nuevo.addRightChild(der);
//
//        return nuevo;
//    }

    public BinaryTree<Integer> suma() {
        reemplazarConSuma(this.ab);
        return this.ab;
    }

    private int reemplazarConSuma(BinaryTree<Integer> ab) {
        if (ab == null) return 0;

        int sumaIzq = 0;
        int sumaDer = 0;

        if (ab.hasLeftChild()) {
            sumaIzq = reemplazarConSuma(ab.getLeftChild());
        }

        if (ab.hasRightChild()) {
            sumaDer = reemplazarConSuma(ab.getRightChild());
        }

        int valorOriginal = ab.getData();
        ab.setData(sumaIzq + sumaDer);
        return valorOriginal + sumaIzq + sumaDer;
    }


    public static void printPreorden(BinaryTree<Integer> ab) {
        if (ab == null) return;
        System.out.println(ab.getData());
        if (ab.hasLeftChild()) printPreorden(ab.getLeftChild());
        if (ab.hasRightChild()) printPreorden(ab.getRightChild());
    }

    public static void main(String[] args) {
        // Crear árbol de ejemplo
        BinaryTree<Integer> raiz = new BinaryTree<>(10);
        BinaryTree<Integer> izq = new BinaryTree<>(5);
        BinaryTree<Integer> der = new BinaryTree<>(3);
        BinaryTree<Integer> hoja1 = new BinaryTree<>(2);
        BinaryTree<Integer> hoja2 = new BinaryTree<>(1);

        izq.addLeftChild(hoja1);
        izq.addRightChild(hoja2);
        raiz.addLeftChild(izq);
        raiz.addRightChild(der);

        // Aplicar transformación
        Transformacion t = new Transformacion(raiz);
        BinaryTree<Integer> nuevo = t.suma();

        // Mostrar árbol transformado en preorden
        System.out.println("Árbol transformado (preorden):");
        printPreorden(nuevo);
    }



}
