package tp2.ejercicio9;

public class Par {
    private int suma;
    private int diferencia;

    public Par(int suma, int diferencia) {
        this.suma = suma;
        this.diferencia = diferencia;
    }

    public int getSuma() {
        return suma;
    }

    public int getDiferencia() {
        return diferencia;
    }

    public String toString() {
        return suma + "|" + diferencia;
    }

}
