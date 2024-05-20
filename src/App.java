import java.sql.SQLException;

import nuestroCRUD.MiCRUD;
import nuestroCRUD.MyColumn;
import nuestroCRUD.MyConstraint;

public class App {
    public static void main(String[] args) {
        MiCRUD prueba = new MiCRUD("bank");

        // 0- null o algo null tb.
        // 0 constrains y 0 columnas
        // 1- 0 columnas
        //  1.1 con una constrain
        //  1.2 con más de una constrain

        // 2- 0 constrains
        //  2.1 con una columna
        //  2.2 con más de una columna.

        MyColumn[] columnas = new MyColumn[2];
        columnas[0] = new MyColumn();
        columnas[0].setColName("nombre");
        columnas[0].setColType("varchar(32)");
        MyConstraint[] restricciones= new MyConstraint[5];
        // MyConstraint[] restricciones = new MyConstraint[];
        System.out.print("Salida: ");
        System.out.println(prueba.createTable("mi tabla", columnas, restricciones));
        
    }
}
