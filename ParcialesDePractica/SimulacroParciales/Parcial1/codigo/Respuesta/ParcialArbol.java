package org.example.Parcial6;

import org.example.practica1Ej8.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class ParcialArbol {

    public List<Estacion> mejorRutaEficiente(GeneralTree<Estacion> arbol) {
        List<Estacion> caminoActual = new ArrayList<>();
        List<Estacion> caminoMinimo = new ArrayList<>();


        double sumaEnergia = 0;
        double sumaTiempo = 0;

        Maximo maximo = new Maximo(0);
        for (GeneralTree<Estacion> hijo : arbol.getChildren()) {
            mejorRutaHelper(hijo, caminoActual, caminoMinimo, sumaEnergia, sumaTiempo,  maximo);
        }

        return caminoMinimo;
    }

    public static void mejorRutaHelper(GeneralTree<Estacion> nodo,
                                       List<Estacion> caminoActual, List<Estacion> caminoMinimo,
                                       double sumaEnergia, double sumaTiempo,
                                       Maximo maximo) {

        caminoActual.add(nodo.getData());
        sumaTiempo += nodo.getData().getTiempo();
        sumaEnergia += nodo.getData().getEnergia();

        if (!nodo.isLeaf()) {
            for (GeneralTree<Estacion> hijo : nodo.getChildren()) {
                mejorRutaHelper(hijo, caminoActual, caminoMinimo, sumaEnergia, sumaTiempo, maximo);
            }
        } else {
            double eficiencia = sumaEnergia / sumaTiempo;
            if (eficiencia > maximo.getMax()) {
                maximo.setMax(eficiencia);
                caminoMinimo.clear();
                caminoMinimo.addAll(caminoActual);
            }

        }
        caminoActual.remove(caminoActual.size() - 1);

    }


}
