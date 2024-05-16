import java.sql.SQLException;

import nuestroCRUD.MiCRUD;

public class App {
    public static void main(String[] args) {
        
        MiCRUD miAcceso = new MiCRUD("banco");
        System.out.println("Creado objeto y url actualizada : " + miAcceso.getUrl());
        boolean continuar = miAcceso.initDriver();
        if (continuar){
            System.out.println("Driver iniciado correctamente.");
        } else {
            System.out.println("Error al iniciar el Driver.");
        }
        continuar = miAcceso.initConnection();
        if (continuar){
            System.out.println("Se ha establecido conexión con la BD.");
        } else {
            System.out.println("Error en la conexión con la BD");
        }
        continuar = miAcceso.createStatement();
        if (continuar){
            System.out.println("Se ha creado el Statement correctamente.");
        } else {
            System.out.println("NO Se ha creado el Statement correctamente.");
        }
    }
}
