package org.example.Parcial5;

import org.example.practica1Ej8.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class Estrategia {

//    Considere que tiene un arbol general en donde cada rama desde la raiz a una hoja es una estrategia distinta.
//    Usted debe elegir la rama con el menor tiempo
//
//    Para calcular los tiempos de cada rama, considere que cada nodo indica la cantidad de vueltas
//    y el compuesto de neumatico (Soft, Med, Hard). La raiz es el unico nodo vacio. El tiempo de cada nodo es:
//
//        (i) para compuestos Soft es cantidad de vueltas * 0
//        (ii) Para compuestos Med es cantidad de vueltas * 0.4
//        (iii) Para compuestos Hard ese cantidad de vueltas * 0.7
//
//    Ademas, debe sumar 10 por cada arista (sin contar las artistas que salen de la raiz)

    public List<Compuesto> mejorEstrategia (GeneralTree<Compuesto> arbol) {
        List<Compuesto> ramaMin = new ArrayList<>();
        List<Compuesto> ramaActual = new ArrayList<>();
        Minimo sumaMinima = new Minimo(999);

        for (GeneralTree<Compuesto> hijo : arbol.getChildren()) {
            mejorEstrategiaHelper(hijo, ramaActual, ramaMin, 0, sumaMinima);
        }

        return ramaMin;
    }

    // Este metodo lo que tiene que hacer es:
    // recorrer los hijos del nodo raiz
    // ir agregando el recorrido desde un nodo hasta una hoja y comparar con los demas recorridos
    // Despues hacer un for y sumar todos sus elementos y comparar con otra lista
    //

    public void mejorEstrategiaHelper(GeneralTree<Compuesto> arbol, List<Compuesto> camAct, List<Compuesto> camMin, double sumaTotal, Minimo sumaMin) {
        camAct.add(arbol.getData());
        sumaTotal += arbol.getData().getTipoCompuesto() * arbol.getData().getCantvueltas();

        if (!arbol.isLeaf()) {
            sumaTotal+= 10;
            for (GeneralTree<Compuesto> c : arbol.getChildren()) {
                mejorEstrategiaHelper(c, camAct, camMin, sumaTotal, sumaMin);
            }
        } else {
            if (sumaTotal < sumaMin.getMin()) {
                sumaMin.setMin(sumaTotal);
                camMin.clear();
                camMin.addAll(camAct);
            }
        }
        camAct.remove(camAct.size() - 1);

    }

}
