import java.io.*;
import java.nio.file.AccessDeniedException;


public class App {
    public static void main(String[] args) throws Exception {
        String archivoInput = "src\\data.txt";
        String archivoOutput = "src\\resultado.txt";

        try (BufferedReader br_Reader = new BufferedReader(new FileReader(archivoInput));
            BufferedWriter br_Writer = new BufferedWriter(new FileWriter(archivoOutput))
        ) {
            
            String lineaLeida;
            while ((lineaLeida = br_Reader.readLine()) != null) {
                
                String lineaProcesada = procesarLinea(lineaLeida);
                
                br_Writer.write(lineaProcesada);
                br_Writer.newLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("El archivos ["+archivoInput+"] no fue encontrado. ("+e+")");
            //Catch para casos donde no se encuentre el archivo de lectura
        }
        catch(AccessDeniedException e){
            System.out.println("No fue posible acceder al archivo ["+archivoInput+"] o generar el archivos de salida en el directoriono fue encontrado. ("+e+")");
            //Catch para casos donde haya conflicto de permisos de lectura, escritura o creacion de archivos 
        }
        catch(IOException e){
            System.out.println("Ha ocurrido un error al querer manejar el archivo de entrada o de salida. ("+e+")");
            //Catch para casos relacionados con IO y que no esten contemplados en los catch anteriores
        }
        catch(Exception e){
            System.out.println("Ha ocurrido un error durante la ejecucion del script. ("+e+")");
            //Catch generico para todo el resto de excepciones
        }
    }

    public static String procesarLinea(String lineaLeida){
        String lineaProcesada = "";


        //TODO metodo para hacer algo con el texto del archivo



        return lineaProcesada;
    }
}
