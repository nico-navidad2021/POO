package poo.ejercicios.uva1.ejercicio1;



public class Ala {
    Float envergadura;
    String color;
    String material;
    Boolean estadoFlap;
    Integer numeroDeAla;

    public Ala(){

    }

    public Ala(Float envergadura, String color, String material, Integer numeroDeAla){
        this.envergadura = envergadura;
        this.color = color;
        this.material = material;
        this.estadoFlap = false;
        this.numeroDeAla = numeroDeAla;
    }

    public Float getEnvergadura(){
        return envergadura;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public Boolean getEstadoFlap() {
        return estadoFlap;
    }    

    public void setEnvergadura(Float envergadura){
        this.envergadura = envergadura;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setEstadoFlap(Boolean estadoFlap) {
        this.estadoFlap = estadoFlap;
    }

    public void activarFlap(){
        this.estadoFlap = true;
    }

    public void getEstadoGeneral(){
        //Este metodo tiene la unica funcion de no llenar el main con un monton de prints
        System.out.println("Estado del ala "+this.getNumeroDeAla());
        System.out.println("Envergadura: "+this.getEnvergadura());
        System.out.println("Color: "+this.getColor());
        System.out.println("Tipo de material: "+this.getMaterial());
        System.out.println("Estado del flap: "+this.getEstadoFlap());
    }

    public Integer getNumeroDeAla() {
        return numeroDeAla;
    }

    public void setNumeroDeAla(Integer numeroDeAla) {
        this.numeroDeAla = numeroDeAla;
    }
    
}
