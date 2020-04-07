package airlines;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.DataBaseFlights;

public class AirLines {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:airlines.db";

    private Connection conn;
    private Statement stat;

    public AirLines(){
        try{
            Class.forName(AirLines.DRIVER);
        } catch (ClassNotFoundException e){
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }

        createTables();

    }
    public boolean createTables()  {

        String createDataBaseFlights = "CREATE TABLE IF NOT EXISTS DataBaseFlights (id_DataBaseFlights INTEGER PRIMARY KEY AUTOINCREMENT, departure varchar(255), arrival varchar(255),price INTEGER PRIMARY KEY AUTOINCREMENT)";

        try {

            stat.execute(createDataBaseFlights);

        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean insertDataBaseFlights(String departure, String arrival, int price) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into DataBaseFlights values (NULL, ?, ?);");
            prepStmt.setString(1, departure);
            prepStmt.setString(2, arrival);
            prepStmt.setString(3, price);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wypozyczaniu");
            return false;
        }
        return true;
    }

    public List<DataBaseFlights> selectDataBaseFlights() {
        List<DataBaseFlights> ksiazki = new LinkedList<DataBaseFlights>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM DataBaseFlights");
            int id, price;
            String departure, arrival;
            while(result.next()) {
                id = result.getInt("DataBaseFlights");
                arrival = result.getString("arrival");
                departure = result.getString("departure");
                price = result.getInt(price);
                DataBaseFlights.add(new DataBaseFlights(id, departure, arrival, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return ksiazki;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }



}
