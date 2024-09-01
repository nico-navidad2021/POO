package televisor;

public class Televisor {
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private char tipo; //P = plasma, L = LCD, O = Oled
    private int tamanioPantalla; //Expresado en pulgadas
    private String resolucion;
    private boolean smart;

    public Televisor(String marca, String modelo, int anioFabricacion, char tipo, int tamanioPantalla,
            String resolucion, boolean smart) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.tipo = tipo;
        this.tamanioPantalla = tamanioPantalla;
        this.resolucion = resolucion;
        this.smart = smart;
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

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getTamanioPantalla() {
        return tamanioPantalla;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isSmart() {
        return smart;
    }

    public void setSmart(boolean smart) {
        this.smart = smart;
    }
    
    
}
