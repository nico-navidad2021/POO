package pantalla;

public class Pantalla {
    private char tipo; //P = plasma, L = LCD, O = Oled
    private int tamanioPantalla; //Expresado en pulgadas

    public Pantalla(char tipo, int tamanioPantalla) {
        this.tipo = tipo;
        this.tamanioPantalla = tamanioPantalla;
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
    public void setTamanioPantalla(int tamanioPantalla) {
        this.tamanioPantalla = tamanioPantalla;
    }

    
}
