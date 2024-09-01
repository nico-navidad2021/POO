import java.util.ArrayList;

import pantalla.Pantalla;
import televisores.Televisor;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList <Televisor> televisores = new ArrayList<>();

        Pantalla pantallaT1 = new Pantalla('O', 43); 
        Pantalla pantallaT2 = new Pantalla('O', 55); 

        Televisor televisor1 = new Televisor("Toshiba", "URSQ-12W", 2024, pantallaT1, "4k", true);
        Televisor televisor2 = new Televisor("Toshiba", "URSQ-42W", 2024, pantallaT2, "4k", true);
        
        televisores.add(televisor1);
        televisores.add(televisor2);

        for (int i = 0; i<televisores.size();i++){
            System.out.println("Caracteristicas principales del telvisor "+(i+1)+":");
            mostrarCaracteristicas(((ArrayList<Televisor>)televisores).get(i));
            mostrarEstado(((ArrayList<Televisor>)televisores).get(i));
        }

        System.out.println("");
        pantallaT1.setTamanioPantalla(44); //Modifico los atributos de la pantalla ya generada

        for (int i = 0; i<televisores.size();i++){
            System.out.println("Caracteristicas principales del telvisor "+(i+1)+":");
            mostrarCaracteristicas(((ArrayList<Televisor>)televisores).get(i));
            mostrarEstado(((ArrayList<Televisor>)televisores).get(i));
        }

        System.out.println("");
        televisor1.encender(); //Modifico los atributos del televisor ya generado

        for (int i = 0; i<televisores.size();i++){
            System.out.println("Caracteristicas principales del telvisor "+(i+1)+":");
            mostrarCaracteristicas(((ArrayList<Televisor>)televisores).get(i));
            mostrarEstado(((ArrayList<Televisor>)televisores).get(i));
        }

    }

    public static void mostrarCaracteristicas(Televisor televisor){
        String marcaTelevisor = ((Televisor) televisor).getMarca();
        String modeloTelevisor = ((Televisor) televisor).getModelo();

        int tamanioPantalla = ((Pantalla)((Televisor) televisor).getPantalla()).getTamanioPantalla(); //ESTA FORMA DE CASTEO ES LA CORRECTA ????

        String resolucionTelevisor = ((Televisor) televisor).getResolucion();
        String smartTelevisor = (((Televisor) televisor).isSmart()) ? "Smart" : "No smart" ;

        System.out.println(marcaTelevisor+" "+modeloTelevisor+" -- "+tamanioPantalla+" pulgadas -- "+resolucionTelevisor+" -- "+smartTelevisor);
    }

    public static void mostrarEstado(Televisor televisor){
        String estado = ((Televisor) televisor).isEncendido() ? "Encendido" : "Apagado";
        System.out.println("El televisor esta en estado: "+estado);
    }
}