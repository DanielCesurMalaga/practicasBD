

import nuestroCRUD.MiCRUD;
import nuestroCRUD.MyColumn;
import nuestroCRUD.MyConstraint;

public class App {
    public static void main(String[] args) {
        MiCRUD miCRUD = new MiCRUD("ferreteria");

        // miCRUD.initDriver();
        miCRUD.initConnection();
        miCRUD.createStatement();

        MyColumn[] columnas = new MyColumn[2];
        columnas[0] = new MyColumn();
        columnas[0].setColName("nombre");
        columnas[0].setColType("varchar(32)");
        columnas[1] = new MyColumn();
        columnas[1].setColName("apellido");
        columnas[1].setColType("varchar(32)");
        columnas[1].setNulleable(true);

        MyConstraint[] restricciones= new MyConstraint[1];
        restricciones[0] = new MyConstraint(true);
        restricciones[0].setParams(new String[] {"pk_nombre","nombre"});

        System.out.println("Creada tabla?: "+miCRUD.createTable("enfermos", columnas, restricciones));
        System.out.println("Borrada tabla?: "+miCRUD.dropTable("enfermos"));

        String[] vista = miCRUD.readBD(new String[] {"cliente.nombre as cliente",
                                                    "empleado.nombre as empleado"}, 
        new String [] {"cliente","empleado","asesora"}, 
        "cliente.id_cliente = asesora.id_cliente and asesora.id_empleado = empleado.dni");
        
        for (String string : vista) {
         System.out.println(string);   
        }
     
    }
}
