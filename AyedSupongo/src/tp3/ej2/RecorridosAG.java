package tp3.ej2;

import tp1.ejercicio8.Queue;
import tp3.ej1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class RecorridosAG {
    private GeneralTree<Integer> a;

    public RecorridosAG() {
    }

    public RecorridosAG(GeneralTree<Integer> a) {
        this.a = a;
    }

    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> l = new LinkedList<Integer>();
        if (!a.isEmpty()) this.numerosImparesMayoresQuePreOrden(a, n, l);
        return l;
    }

    private void numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n, List<Integer> l) {
        int dato = a.getData();
        if (dato % 2 != 0 && dato > n) l.add(dato);
        List<GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer> child : children) {
            numerosImparesMayoresQuePreOrden(child, n, l);
        }
    }

    public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> l = new LinkedList<Integer>();
        if (!a.isEmpty()) this.numerosImparesMayoresQueInOrden(a, n, l);
        return l;
    }

    private void numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n, List<Integer> l) {
        List<GeneralTree<Integer>> children = a.getChildren();
        if (a.hasChildren()) {
            numerosImparesMayoresQueInOrden(children.get(0), n, l);
        }
        int dato = a.getData();
        if (dato % 2 != 0 && dato > n) l.add(dato);
        for (int i = 1; i < children.size(); i++) {
            numerosImparesMayoresQueInOrden(children.get(i), n, l);
        }
    }

    public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> l = new LinkedList<Integer>();
        if (!a.isEmpty()) this.numerosImparesMayoresQuePostOrden(a, n, l);
        return l;
    }

    private void numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n, List<Integer> l) {
        List<GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer> child : children) {
            numerosImparesMayoresQuePostOrden(child, n, l);
        }
        int dato = a.getData();
        if (dato % 2 != 0 && dato > n) l.add(dato);
    }

    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
        List<Integer> result = new LinkedList<Integer>();
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
        queue.enqueue(a);
        while (!queue.isEmpty()) {
            aux = queue.dequeue();
            if (!aux.isEmpty()) {
                int dato = aux.getData();
                if (dato % 2 != 0 && dato > n) result.add(dato);
            }
            List<GeneralTree<Integer>> children = aux.getChildren();
            for (GeneralTree<Integer> child : children) {
                queue.enqueue(child);
            }
        }
        return result;
    }
}
