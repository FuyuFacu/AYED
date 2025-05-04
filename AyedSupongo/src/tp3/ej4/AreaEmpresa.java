package tp3.ej4;

public class AreaEmpresa {
    private String identificafion;
    private int tardanzaMensaje;

    public AreaEmpresa(String identificafion, int tardanzaMensaje) {
        this.identificafion = identificafion;
        this.tardanzaMensaje = tardanzaMensaje;
    }



    public String getIdentificafion() {
        return identificafion;
    }

    public int getTardanzaMensaje() {
        return tardanzaMensaje;
    }


}
