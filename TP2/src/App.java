import java.util.ArrayList;

import televisor.Televisor;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList <Televisor> televisores = new ArrayList<>();
        Televisor televisor1 = new Televisor("Toshiba", "URSQ-12W", 2024, 'O', 43, "4k", true);
        
        televisores.add(televisor1);

        for (int i = 0; i<televisores.size();i++){
            System.out.println("Caracteristicas principales del telvisor "+i+":");
            mostrarCaracteristicas(((ArrayList<Televisor>)televisores).get(i));
        }

    }

    public static void mostrarCaracteristicas(Televisor televisor){
        String marcaTelevisor = ((Televisor) televisor).getMarca();
        String modeloTelevisor = ((Televisor) televisor).getModelo();
        int tamanioTelevisor = ((Televisor) televisor).getTamanioPantalla();
        String resolucionTelevisor = ((Televisor) televisor).getResolucion();
        String smartTelevisor = (((Televisor) televisor).isSmart()) ? "Smart" : "No smart" ;

        System.out.println(marcaTelevisor+" "+modeloTelevisor+" -- "+tamanioTelevisor+" pulgadas -- "+resolucionTelevisor+" -- "+smartTelevisor);
    }
}
