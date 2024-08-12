package poo.ejercicios.uva1.ejercicio1;

public class SistemaDeControlDeVuelo {
    String fabricante;
    Integer numeroDeModos;
    String tipoDeSistema;
    Integer modoVuelo;


    
    public SistemaDeControlDeVuelo() {
    }

    public SistemaDeControlDeVuelo(String fabricante, Integer numeroDeModos, String tipoDeSistema) {
        this.fabricante = fabricante;
        this.numeroDeModos = numeroDeModos;
        this.tipoDeSistema = tipoDeSistema;
        this.modoVuelo = 1;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getNumeroDeModos() {
        return numeroDeModos;
    }

    public void setNumeroDeModos(Integer numeroDeModos) {
        this.numeroDeModos = numeroDeModos;
    }

    public String getTipoDeSistema() {
        return tipoDeSistema;
    }

    public void setTipoDeSistema(String tipoDeSistema) {
        this.tipoDeSistema = tipoDeSistema;
    }

    public Integer getModoVuelo() {
        return modoVuelo;
    }

    public void setModoVuelo(Integer modoVuelo) {
        if (modoVuelo < this.numeroDeModos && modoVuelo>0) {
            this.modoVuelo = modoVuelo;    
        }else{
            System.out.println("El modo de vuelo ingresado no es un modo valido.");
        }
    }

    public void getEstadoGeneral(){
        //Este metodo tiene la unica funcion de no llenar el main con un monton de prints
        System.out.println("Fabricante "+this.getFabricante());
        System.out.println("Numero de modos: "+this.getNumeroDeModos());
        System.out.println("Tipo de sistema: "+this.getTipoDeSistema());
        System.out.println("Modo activo: "+this.getModoVuelo());
    }    



}
