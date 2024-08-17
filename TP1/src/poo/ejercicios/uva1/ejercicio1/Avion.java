package poo.ejercicios.uva1.ejercicio1;

class Motor {
    private String marca;
    private int potencia; 
    private int empuje;
    private boolean encendido;

    public Motor(String marca, int potencia, int empuje) {
        this.marca = marca;
        this.potencia = potencia;
        this.empuje = empuje;
    }

    public String getMarca() {
        return marca;
    }

    public int getPotencia() {
        return potencia;
    }
    
    public int getEmpuje() {
        return empuje;
    }
    
    public void arrancarMotor() {
        this.encendido = true;
    }
    
    public void detenerMotor() {
        this.encendido = false;
    }
}

class SistemaControlVuelo {
    private String fabricante;
    private int numeroModos;
    private String tipoSistema;
    private int modoActual;

    public SistemaControlVuelo(String fabricante, int numeroModos, String tipoSistema) {
        this.fabricante = fabricante;
        this.numeroModos = numeroModos;
        this.tipoSistema = tipoSistema;
        this.modoActual = 1; 
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getNumeroModos() {
        return numeroModos;
    }

    public String getTipoSistema() {
        return tipoSistema;
    }

    public int getModoActual() {
        return modoActual;
    }

    public void cambiarModo(int nuevoModo) {
        modoActual = nuevoModo;
    }
}

class Ala {
    private double envergadura; 
    private String color;
    private String material;

    public Ala(double envergadura, String color, String material) {
        this.envergadura = envergadura;
        this.color = color;
        this.material = material;
    }

    public double getEnvergadura() {
        return envergadura;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public void flap() {
        System.out.println("Flap activado.");
    }
}

class Avion {
    private String marca;
    private String modelo;
    private Motor motor;
    private SistemaControlVuelo sistemaControlVuelo;
    private Ala[] alas;
    private int numeroAsientos;
    private boolean sistemaEntretenimientoABordo;

    public Avion(String marca, String modelo, Motor motor, SistemaControlVuelo sistemaControlVuelo, Ala[] alas, int numeroAsientos, boolean sistemaEntretenimientoABordo) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.sistemaControlVuelo = sistemaControlVuelo;
        this.alas = alas;
        this.numeroAsientos = numeroAsientos;
        this.sistemaEntretenimientoABordo = sistemaEntretenimientoABordo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Motor getMotor() {
        return motor;
    }

    public SistemaControlVuelo getSistemaControlVuelo() {
        return sistemaControlVuelo;
    }

    public Ala[] getAlas() {
        return alas;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public boolean tieneSistemaEntretenimientoABordo() {
        return sistemaEntretenimientoABordo;
    }

}

public class Avion {
    public static void main(String[] args) {
        Motor motor = new Motor("Motor 1", 1000, 2000);

        SistemaControlVuelo sistemaControlVuelo = new SistemaControlVuelo("Sistema1", 2, "manual");

        Ala ala1 = new Ala(1.0, "Blanco", "Metal");
        Ala ala2 = new Ala(2.0, "Gris", "Acero");
        Ala[] alas = {ala1, ala2};

        Avion avion = new Avion("Avion1", "234abc", motor, sistemaControlVuelo, alas, 50, true);

    System.out.println(avion.getMarca());
    }
}
