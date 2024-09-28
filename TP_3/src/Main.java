public class Main {
    public static void main(String[] args) throws Exception {
        Vehiculo v0 = new Vehiculo();
        Vehiculo v1 = new Coche();
        Vehiculo v2 = new Bicicleta();

        System.out.println(v0.desplazar());
        System.out.println(v1.desplazar());
        //Desplazar() sobreescrito para Bicicleta
        System.out.println(v2.desplazar());


        Coche c0 = new Coche();
        //Desplazar(modo) sobrecargado para Coche
        System.out.println(c0.desplazar("automático"));
        System.out.println(c0.desplazar("normal"));
    }
}
