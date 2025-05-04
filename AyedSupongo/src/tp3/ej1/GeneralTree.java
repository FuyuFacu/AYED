package tp3.ej1;

import tp1.ejercicio8.Queue;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

	public GeneralTree() {

	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}

	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}

	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}

	public boolean hasChildren() {
		return !this.children.isEmpty();
	}

	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}

	public int altura() {
		return (!this.isEmpty()) ? alturaHelper() : -1;
	}

	private int alturaHelper() {
		if(this.isLeaf()) return 0;
		else {
			int alturaMax = -1;
			List<GeneralTree<T>> children = this.getChildren();
			for(GeneralTree<T> child: children) {
				alturaMax = Math.max(alturaMax, child.alturaHelper());
			}
			return alturaMax + 1;
		}
	}


	public int nivel(T dato) {
		return (!this.isEmpty()) ? nivelHelper(dato) : -1;
	}

	private int nivelHelper(T dato){
		int nivelActual = 0;
		int act;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enqueue(this);
		while(!cola.isEmpty()){
			act = cola.size();
			for(int i = 0; i < act; ++i){
				aux = cola.dequeue();
				if(aux.getData().equals(dato)){
					return nivelActual;
				}
				for(GeneralTree<T> child : aux.getChildren()){
					cola.enqueue(child);
				}
			}
			nivelActual++;
		}
		return -1;
	}

	public int ancho(){
		if(this.isEmpty()) return 0;
		else return (!this.isLeaf()) ? anchoHelper() : 1;
	}

	private int anchoHelper() {
		int cantMax = 0;
		int cantActual = 0;
		GeneralTree<T> ab;
		Queue <GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			ab = cola.dequeue();
			if (ab != null) {
				List<GeneralTree<T>> children = ab.getChildren();
				for (GeneralTree<T> child : children ) {
					cola.enqueue(child);
					cantActual++;
				}
			} else if (!cola.isEmpty()) {
				cantMax = Math.max(cantMax, cantActual);
				cantActual = 0;
				cola.enqueue(null);
			}
		}
		return cantMax;
	}

//	Se dice que un nodo n es ancestro de un nodo m si existe un camino desde n a m. Implemente un
//	metodo en la clase GeneralTree con la siguiente firma:
//	public boolean esAncestro(T a, T b): devuelve true si el valor “a” es ancestro del valor “b”.

	public boolean esAncestro(T a, T b) {
		GeneralTree<T> nodoA = buscarNodo(a);
		if (nodoA == null) return false;
		return nodoA.buscarNodo(b) != null;

	}

	public GeneralTree<T> buscarNodo(T a) {
		if (this.getData().equals(a)) {
			return this;
		}
		for (GeneralTree<T> child : this.getChildren()) {
			GeneralTree<T> aux = child.buscarNodo(a);
			if (aux != null) return aux;
		}
		return null;
	}


}