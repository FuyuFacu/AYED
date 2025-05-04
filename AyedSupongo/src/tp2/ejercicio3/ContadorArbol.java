package tp2.ejercicio3;

import java.util.ArrayList;
import java.util.List;

import tp2.ejercicio1Y2.BinaryTree;

public class ContadorArbol {
	private BinaryTree<Integer> ab;
	
    // Constructor
    public ContadorArbol(BinaryTree<Integer> arbol) {
        this.ab = arbol;
    }
    
    public List<Integer> getNumerosParesPostOrden() {
    	List<Integer> listaPares = new ArrayList<>();
    	if (this.ab != null) numerosParesPostOrdenRecursivo(this.ab, listaPares);
    	return listaPares;
    }
    
    private void numerosParesPostOrdenRecursivo(BinaryTree<Integer> nodo, List<Integer> lista) {
    	if (nodo.hasLeftChild()) numerosParesPostOrdenRecursivo(nodo.getLeftChild(), lista);
    	if (nodo.hasRightChild()) numerosParesPostOrdenRecursivo(nodo.getRightChild(), lista);
    	if (nodo != null && nodo.getData() % 2 == 0) lista.add(nodo.getData());
    }
    
    
    public List<Integer> getNumerosParesInOrden() {
    	List<Integer> listaPares = new ArrayList<>();
    	if (this.ab != null) {
    		numerosParesInOrdenRecursivo(this.ab, listaPares);
    	}
    	return listaPares;
    }
    
    private void numerosParesInOrdenRecursivo(BinaryTree<Integer> nodo, List<Integer> lista) {
    	if (nodo.hasLeftChild()) numerosParesInOrdenRecursivo(nodo.getLeftChild(), lista);
 
    	if (nodo != null && nodo.getData() % 2 == 0) lista.add(nodo.getData());
    	
    	if (nodo.hasRightChild()) numerosParesInOrdenRecursivo(nodo.getRightChild(), lista);
    	
    }
    
    
    
    
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
		BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(78);
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		ContadorArbol contador = new ContadorArbol(ab);
		List<Integer> lista_pares = contador.getNumerosParesInOrden();
		System.out.println("Lista de numero pares en orden InOrden: ");
		System.out.println(lista_pares);
		System.out.println("Lista de numero pares en orden PostOrden: ");
		lista_pares = contador.getNumerosParesPostOrden();
		System.out.println(lista_pares);
	}
	
}
