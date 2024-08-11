import poo.ejercicios.uva1.ejercicio1.Ala;


public class App {
    public static void main(String[] args) throws Exception {


        Ala ala1 = new Ala( (float) 22.21, "Rojo", "Alumninio",1);
        Ala ala2 = new Ala((float) 25.2, "Amarillo", "Aleacion de niquel",2);

        System.out.println("--Estado inicial de las alas--");
        System.out.println("");

        ala1.getEstadoGeneral();

        System.out.println("----------------------------");

        ala2.getEstadoGeneral();

        ala1.activarFlap();
        ala2.activarFlap();

        System.out.println("");

        ala1.getEstadoGeneral();

        System.out.println("----------------------------");

        ala2.getEstadoGeneral();

    }
}
