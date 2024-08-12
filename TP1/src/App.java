import poo.ejercicios.uva1.ejercicio1.Ala;
import poo.ejercicios.uva1.ejercicio1.SistemaDeControlDeVuelo;


public class App {
    public static void main(String[] args) throws Exception {

        //ALA
        Ala ala1 = new Ala( (float) 22.21, "Rojo", "Alumninio",1);
        Ala ala2 = new Ala((float) 25.2, "Amarillo", "Aleacion de niquel",2);

        System.out.println("INFORMACION CONTROL DE VUELO");
        System.out.println("");

        ala1.getEstadoGeneral();

        System.out.println("----------------------------");

        ala2.getEstadoGeneral();

        System.out.println("Activo flap del ala1...");
        ala1.activarFlap();
        System.out.println("Activo flap del ala2...");
        ala2.activarFlap();

        System.out.println("");

        ala1.getEstadoGeneral();

        System.out.println("----------------------------");

        ala2.getEstadoGeneral();

        //CONTROL DE VUELO
        SistemaDeControlDeVuelo modo1 = new SistemaDeControlDeVuelo("AeroData", 2, "Automatico");
        SistemaDeControlDeVuelo modo2 = new SistemaDeControlDeVuelo("Avidyne", 3, "Manual");

        System.out.println("INFORMACION CONTROL DE VUELO");
        System.out.println("");
        modo1.getEstadoGeneral();
        System.out.println("----------------------------");
        modo2.getEstadoGeneral();
        System.out.println("");

        modo1.setModoVuelo(1);
        modo2.setModoVuelo(0);

        modo1.getEstadoGeneral();
        System.out.println("----------------------------");
        modo2.getEstadoGeneral();
    }
}
