package televisores;

import pantalla.Pantalla;

public class Televisor {
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private Pantalla pantalla;
    private String resolucion;
    private boolean smart;
    private boolean encendido;

    public Televisor(String marca, String modelo, int anioFabricacion, Pantalla pantalla,
            String resolucion, boolean smart) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.pantalla = pantalla;
        this.resolucion = resolucion;
        this.smart = smart;
        this.encendido = false;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void encender() {
        this.encendido = true;
    }

    public void apagar() {
        this.encendido = false;
    }

    public boolean isSmart() {
        return smart;
    }

    public void setSmart(boolean smart) {
        this.smart = smart;
    }
    
    public Pantalla getPantalla() {
        return pantalla;
    }
    
}