package org.example.SimulacroParcial;

import org.example.Parcial6.Estacion;
import org.example.practica1Ej8.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class ParcialArbol {


    public List<EstacionDistribucion> rutaMasEficiente(GeneralTree<EstacionDistribucion> arbol) {
        List<EstacionDistribucion> caminoEficiente = new ArrayList<>();
        List<EstacionDistribucion> caminoActual = new ArrayList<>();
        Maximo maximo = new Maximo(-1); // eficiencia inicial

        rutaMasEficienteHelper(arbol, caminoEficiente, caminoActual, 0, 0, 0, maximo);

        return caminoEficiente;
    }

    public void rutaMasEficienteHelper(GeneralTree<EstacionDistribucion> nodo,
                                       List<EstacionDistribucion> camEficiente, List<EstacionDistribucion> camActual,
                                       double energiaTotal, double tiempoDemoraTotal, int penalizaciones,
                                       Maximo maximo) {
        camActual.add(nodo.getData());
        energiaTotal += nodo.getData().getEnergiaTransferida();
        tiempoDemoraTotal += nodo.getData().getTiempoDemora();
        if (nodo.getData().esCritica) penalizaciones += 5;

        if (!nodo.isLeaf()) {
            for (GeneralTree<EstacionDistribucion> hijo : nodo.getChildren()) {
                rutaMasEficienteHelper(hijo, camEficiente, camActual, energiaTotal, tiempoDemoraTotal, penalizaciones, maximo);
            }
        } else {
            double eficiencia = energiaTotal / (tiempoDemoraTotal + penalizaciones);
            if (eficiencia > maximo.getMax()) {
                maximo.setMax(eficiencia);
                camEficiente.clear();
                camEficiente.addAll(camActual);
            }
        }

        camActual.remove(camActual.size() - 1);

    }

}
