package tp3.ej6;

import tp3.ej1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class RedDeAguaPotable {
    GeneralTree<Character> redAgua;

    public RedDeAguaPotable(GeneralTree<Character> ab) {
        this.redAgua = ab;
    }

    public double minimoCaudal(double caudal) {
        if (redAgua == null || redAgua.isEmpty()) return 0;
        return caudalMinimo(redAgua, caudal);
    }


    private double caudalMinimo(GeneralTree<Character> nodo, double caudal) {
        // Si es que no tiene hijos, devolvemos el caudal recibido
        if (!nodo.hasChildren()) {
            return caudal;
        }

        int numHijos = nodo.getChildren().size();
        double caudalPorHijo = caudal / numHijos;


        // Es hora de la recursion
        double caudalMinimo = Double.MAX_VALUE;
        for (GeneralTree<Character> child : nodo.getChildren()) {
            caudalMinimo = Math.min(caudalMinimo, caudalMinimo(child, caudalPorHijo));
        }
        return caudalMinimo;
    }

    public static void main(String[] args) {
        // CASO 1: Árbol vacío
        GeneralTree<Character> arbolVacio = new GeneralTree<>();
        RedDeAguaPotable redVacia = new RedDeAguaPotable(arbolVacio);
        System.out.println("Caso 1 (vacío) - Esperado: 0.0, Obtenido: " + redVacia.minimoCaudal(1000.0));

        // CASO 2: Árbol con un solo nodo (una hoja)
        GeneralTree<Character> arbolHoja = new GeneralTree<>('A');
        RedDeAguaPotable redHoja = new RedDeAguaPotable(arbolHoja);
        System.out.println("Caso 2 (una casa) - Esperado: 1000.0, Obtenido: " + redHoja.minimoCaudal(1000.0));

        // CASO 3: Árbol con varias bifurcaciones
        // Estructura:
        //        A
        //      / | \
        //     B  C  D
        //          |
        //          E

        GeneralTree<Character> nodoB = new GeneralTree<>('B');
        GeneralTree<Character> nodoC = new GeneralTree<>('C');
        GeneralTree<Character> nodoE = new GeneralTree<>('E');
        List<GeneralTree<Character>> hijosD = new LinkedList<>();
        hijosD.add(nodoE);
        GeneralTree<Character> nodoD = new GeneralTree<>('D', hijosD);

        List<GeneralTree<Character>> hijosA = new LinkedList<>();
        hijosA.add(nodoB);
        hijosA.add(nodoC);
        hijosA.add(nodoD);
        GeneralTree<Character> nodoA = new GeneralTree<>('A', hijosA);

        RedDeAguaPotable red = new RedDeAguaPotable(nodoA);
        System.out.println("Caso 3 (estructura con bifurcaciones) - Esperado: 333.3, Obtenido: " + red.minimoCaudal(1000.0));
    }




}
