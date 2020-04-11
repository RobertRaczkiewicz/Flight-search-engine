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
            System.err.println("No driver JDBC");
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem with opening the connection");
            e.printStackTrace();
        }

        createTables();

    }
    public boolean createTables()  {

        String createFlights = "CREATE TABLE IF NOT EXISTS Flights (id_Flights INTEGER PRIMARY KEY AUTOINCREMENT, departure varchar(255), arrival varchar(255),price INTEGER)";

        try {

            stat.execute(createFlights);

        } catch (SQLException e) {
            System.err.println("Error during table creation");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean insertDataBaseFlights(String departure, String arrival, int price) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Flights values (NULL, ?, ?, ?);");
            prepStmt.setString(1, departure);
            prepStmt.setString(2, arrival);
            prepStmt.setInt(3, price);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Error in creating list of flights");
            return false;
        }
        return true;
    }

    public List<DataBaseFlights> selectFlights() {
        List<DataBaseFlights> flights = new LinkedList<DataBaseFlights>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Flights");
            int id, price;
            String departure, arrival;
            while(result.next()) {
                id = result.getInt("id_Flights");
                arrival = result.getString("arrival");
                departure = result.getString("departure");
                price = result.getInt("price");
                flights.add(new DataBaseFlights(id, departure, arrival, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return flights;
    }

    public void closeConnection() {
        try {
                        conn.close();
        } catch (SQLException e) {
            System.err.println("Problem with closing the connection");
            e.printStackTrace();
        }
    }



}
