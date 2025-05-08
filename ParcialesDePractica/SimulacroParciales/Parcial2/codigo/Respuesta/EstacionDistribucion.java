package org.example.SimulacroParcial;

public class EstacionDistribucion {

    private double energiaTransferida;
    private double tiempoDemora;
    boolean esCritica;

    public EstacionDistribucion(double energiaTransferida, double tiempoDemora, boolean esCritica) {
        this.energiaTransferida = energiaTransferida;
        this.tiempoDemora = tiempoDemora;
        this.esCritica = esCritica;
    }

    public double getEnergiaTransferida() {
        return energiaTransferida;
    }

    public double getTiempoDemora() {
        return tiempoDemora;
    }

    public boolean isEsCritica() {
        return esCritica;
    }
}
