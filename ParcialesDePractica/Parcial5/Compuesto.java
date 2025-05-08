package org.example.Parcial5;

public class Compuesto {
    private String tipoCompuesto;
    private int cantvueltas;
    private boolean salenDeRaiz;

    public int getCantvueltas() {
        return cantvueltas;
    }

    public Compuesto(String tipoCompuesto) {
        this.tipoCompuesto = tipoCompuesto;
    }

    public double getTipoCompuesto() {
        if (tipoCompuesto == "Soft") return 0;
        else if (tipoCompuesto == "Med") return 0.4;
        else if (tipoCompuesto == "Hard") return 0.7;
        return 0;
    }


}
