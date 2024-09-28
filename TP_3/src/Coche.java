public class Coche extends Vehiculo{

    public String desplazar(String modo) {
        if ("automático".equals(modo)) {
            return "Coche desplazándose en modo automático";
        } else {
            return "Coche desplazándose en modo normal";
        }
    }
}
