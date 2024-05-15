package apuntes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableBank {
   // Attributes
   String driver = "com.mysql.cj.jdbc.Driver";
   String url = "jdbc:mysql://localhost:3306/bank";
   String login = "root";
   String password = "";
   String createTableBank = "CREATE TABLE banco (" +
         "client VARCHAR(100) NOT NULL, " +
         "password VARCHAR(20) NOT NULL, " +
         "balance Integer NOT NULL, " +
         "PRIMARY KEY(client))";

   String createInsertInto = "INSERT INTO BANCO " +
         "(client,password,balance) VALUES " +
         "('Jose Antonio','c',10)";

   String createSelect = "select * from banco";
   // insertar un elemento.
   // seleccionar un elemento.
   Connection connection;
   Statement statement;

   public void CreateTableBank() {
   }

   public void initConnection() {
      try {
         Class.forName(driver);
      } catch (ClassNotFoundException e) {
         System.out.println(e.getMessage());
      }
      try {
         connection = DriverManager.getConnection(url, login, password);

      } catch (SQLException e) {
         System.out.println(e.getMessage());
      }
   }

   public void createStatement(){
      try {
         statement = connection.createStatement();
      } catch (SQLException e) {
         System.out.println(e.getMessage());
      }
   }

   public void useStatement(){
      try {
         statement.executeUpdate(createTableBank);
      } catch (SQLException e) {
         System.out.println("al crear la tabla");
         System.out.println(e.getMessage());
      }
   }

   public void useStatementInsert(){
      try {
         statement.executeUpdate(createInsertInto);
      } catch (SQLException e) {
         System.out.println("al crear la tabla");
         System.out.println(e.getMessage());
      }
   }

   public void useSelect(){
      try {
         ResultSet vista = statement.executeQuery(createSelect);
         ResultSetMetaData datosVista = vista.getMetaData();
         System.out.println("El nombre de la tabla es: "+ datosVista.getTableName(1));
         System.out.println("Número de filas:  "+ vista.getFetchSize());
         while (vista.next()){
            for (int i = 1; i <= datosVista.getColumnCount(); i++) {
               System.out.print("["+datosVista.getColumnName(i)+" : " + vista.getString(i)+"] ");
            }
            System.out.println();
         }
         System.out.println("El puntero al final apunta a: "+ vista.getRow());
      } catch (SQLException e) {
         System.out.println(e.getMessage());
      }
   }

   public void closeConnection() {
      try {
         connection.close();
      } catch (SQLException e) {
         System.out.println(e.getMessage());
      }
   }

} // end class