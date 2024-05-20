import java.sql.SQLException;

import nuestroCRUD.MiCRUD;
import nuestroCRUD.MyColumn;
import nuestroCRUD.MyConstraint;

public class App {
    public static void main(String[] args) {
        MiCRUD prueba = new MiCRUD("bank");

        MyColumn[] columnas = new MyColumn[2];
        columnas[0] = new MyColumn();
        columnas[0].setColName("nombre");
        columnas[0].setColType("varchar(32)");
        columnas[1] = new MyColumn();
        columnas[1].setColType("varchar(32)");
        columnas[1].setNulleable(true);

        MyConstraint[] restricciones= new MyConstraint[3];
        restricciones[0] = new MyConstraint(true);
        restricciones[0].setParams(new String[] {"pk_nombre","nombre"});
        restricciones[1] = new MyConstraint(false);
        restricciones[1].setParams(new String[] {"fk_nombre1","apellido1","habitacion1","codigo1"});
        restricciones[2] = new MyConstraint(false);
        restricciones[2].setParams(new String[] {"fk_nombre2","apellido2","habitacion2","codigo2"});
        
        System.out.print("Salida: ");
        System.out.println(prueba.createTable("mi tabla", columnas, restricciones));      
    }
}
