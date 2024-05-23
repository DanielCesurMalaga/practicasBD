

import nuestroCRUD.MiCRUD;
import nuestroCRUD.MyColumn;
import nuestroCRUD.MyConstraint;

public class App {
    public static void main(String[] args) {
        MiCRUD miCRUD = new MiCRUD("bank");

        // miCRUD.initDriver();
        miCRUD.initConnection();
        miCRUD.createStatement();

        miCRUD.insertRow("banco", new String[]{"balance","client","password"}, new Object[]{999,"SUPERMAN","KRIPTONITA"});

        miCRUD.closeConnection();
     
    }
}
