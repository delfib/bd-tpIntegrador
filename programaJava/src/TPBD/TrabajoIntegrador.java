package TPBD;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TrabajoIntegrador {
    
    public static void main(String[] args) throws Exception {
        insertarHabitacion();
        registrarCliente();
    }

    //Get the Connection
    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/TP(Buil_Buttignol_Compagnucci)";
            String username = "root";
            String password = "M3#5nJ$F1@#28b"; //or root

            //Load database driver if not already loaded.
            Class.forName(driver);

            //Establish network connection to database.
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connectada");
            return connection;
        } catch(Exception e){System.out.println(e);}
        return null;
    }


    //Insertar una nueva habitación
    public static void insertarHabitacion() throws Exception {
        /*
        final int nro = 300;
        final String cant_camas = "doble";
        final int cod = 4;
        */
        Scanner scan = new Scanner(System.in);

            System.out.println("Ingrese el número de la nueva habitacion");
            int nro = scan.nextInt();

            System.out.println("Ingrese la cantidad de camas de la nueva habitacion");
            String cant_camas = scan.next();

            System.out.println("Ingrese el codigo de la nueva habitacion");
            int cod = scan.nextInt();

        //in.close();

        try{
            Connection connection = getConnection();
            String query = "INSERT INTO habitaciones (nro_habitacion, cant_camas, cod_habitacion) VALUES ('"+nro+"', '"+cant_camas+"', '"+cod+"')";
            PreparedStatement insert = connection.prepareStatement(query);
            insert.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("Insercion completada con exito");
        }
    }


    //Registrar un cliente en una habitación en la fecha actual
    public static void registrarCliente() throws Exception {
        //resuelta para clientes ya registrados en la base de datos.
        //INSERT INTO es_ocupada (nro_habitacion, fecha, dni, cant_dias, monto_total) VALUES (101, NOW(), 25789562, 8, 40000); 
        //UPDATE es_ocupada SET fecha = NOW(), dni = 34456123, cant_dias = 6, monto_total = 30000 where nro_habitacion = 201;

        Scanner scan = new Scanner(System.in);
            System.out.println("Ingrese la habitacion en la que se hospedara el cliente");
            int nro_habitacion = scan.nextInt();

            System.out.println("Ingrese el dni del cliente");
            int dni = scan.nextInt();

            System.out.println("Ingrese la cantidad de dias que se hospedara");
            int cant_dias = scan.nextInt();

            System.out.println("Ingrese el monto total del hospedaje");
            int monto_total = scan.nextInt();
        
        try{
            Connection connection = getConnection();
            String query = "INSERT INTO es_ocupada (nro_habitacion, fecha, dni, cant_dias, monto_total) VALUES ('"+nro_habitacion+"', NOW(), '"+dni+"', '"+cant_dias+"', '"+monto_total+"')";
            PreparedStatement insert = connection.prepareStatement(query);
            insert.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("Insercion completada con exito");
        }
    }

    //Lista todos los clientes y fechas en que se registraron en una determinada habitación. 


}
        

            /*
            String query = "SELECT * FROM persona";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            //Print results
            while(resultSet.next()) {
                System.out.println("DNI: " + resultSet.getString(1));
                System.out.println("; Direccion: " + resultSet.getString(2));
                System.out.println("; Nombre y Apellido: " + resultSet.getString(3));
                System.out.println("; Fecha de Nacimiento: " + resultSet.getString(4));
                System.out.println("; Edad: " + resultSet.getString(5));
                System.out.println("\n    ");
                System.out.println("\n    ");
            }
        }   catch(ClassNotFoundException cnfe){
            System.err.println("Error loading driver: " + cnfe);
            
        }   catch(SQLException sqle){
            sqle.printStackTrace();
            System.err.println("Error connecting: " + sqle);
        }
    }
}
*/

