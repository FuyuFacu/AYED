package tp2.ejercicio1Y2;

import java.util.*;

public class BinaryTree <T> {

    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;


    public BinaryTree() {
        super();
    }

    public BinaryTree(T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    /**
     * Preguntar antes de invocar si hasLeftChild()
     * @return
     */
    public BinaryTree<T> getLeftChild() {
        if (this.hasLeftChild()) return leftChild;
        else throw new IllegalArgumentException("No se encontró ningún hijo en el lado izquierdo");
    }
    /**
     * Preguntar antes de invocar si hasRightChild()
     * @return
     */
    public BinaryTree<T> getRightChild() {
        if (this.hasRightChild()) return this.rightChild;
        else throw new IllegalArgumentException("No se encontró nigún hijo en el lado derecho");
    }

    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty(){
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());

    }

    public boolean hasLeftChild() {
        return this.leftChild!=null;
    }

    public boolean hasRightChild() {
        return this.rightChild!=null;
    }
    @Override
    public String toString() {
        return this.getData().toString();
    }

    public void imprimirArbol() {
        if (this.hasLeftChild()) this.getLeftChild().imprimirArbol();
        System.out.println(this.getData());
        if (this.hasRightChild()) this.getRightChild().imprimirArbol();

    }


    public int contarHojas() {
        if (this.data == null) {
            return 0;
        }
        int total = 0;

        if (this.isLeaf()) return 1;

        if (this.hasLeftChild()) total += this.getLeftChild().contarHojas();
        if (this.hasRightChild()) total += this.getRightChild().contarHojas();
        return total;
    }



    public BinaryTree<T> espejo(){

        BinaryTree<T> ab = new BinaryTree<T>(this.getData());

        if (this.hasLeftChild()) {
            ab.addRightChild(this.getLeftChild().espejo());
        }

        if (this.hasRightChild()) {
            ab.addLeftChild(this.getRightChild().espejo());
        }

        return ab;
    }

    // 0<=n<=m
    public void entreNiveles(int n, int m) {
        if (this.isEmpty() || n < 0 || m < n) return;
        Queue<BinaryTree<T>> cola = new LinkedList<>();
        cola.add(this); // agrego a la cola la Lista
        int nivelActual = 0; // Inicializo el nivel actual

        while(!cola.isEmpty()) { // Pregunto si la cola esta vacia
            int nodoNivel = cola.size(); //Saco el size de la cola
            if(nivelActual >=n && nivelActual <= m) { // Pregunto si el nivel actual se encuentra dentro del rango pedido en n y m
                for(int i=0; i < nodoNivel; i++) { // Hago un for por cada elemento de la cola
                    BinaryTree<T> nodo = cola.remove(); // consido el nodo
                    System.out.print(nodo.getData() + " | "); // Imprimo el nodo con el sysyem.out.println
                    if(nodo.hasLeftChild()) cola.add(nodo.getLeftChild()); // Pregunto si el nodo posee un hijo izquierdo, y si es asi agrego a al cola el hijo
                    if(nodo.hasRightChild()) cola.add(nodo.getRightChild()); // Pregunto si el nodo posee un hijo derecho, y si es asi agrego a al cola el hijo
                }
            } else { // si no se encuentra el nivel dentro del rango pedido
                for(int i=0; i < nodoNivel; i++) { //Elimino todos los elementos de la cola
                    cola.remove();
                }
            }
            nivelActual++; // Incremento el nivel actual
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
        BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
        hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
        hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
        BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(78);
        ab.addLeftChild(hijoIzquierdo);
        ab.addRightChild(hijoDerecho);
        System.out.println("Cantidad de hojas que tiene este arbol son: " + ab.contarHojas());
        System.out.println("Arbol original: ");
        ab.imprimirArbol();
        System.out.println("Arbol Espejo: ");
        ab.espejo().imprimirArbol();
        System.out.println("Entre Niveles: ");
        ab.entreNiveles(0,2);

    }

}


