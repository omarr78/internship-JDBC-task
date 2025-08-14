import java.sql.*;

public class DatabaseConnection {
    private static Connection connection;
    private static final String url = "jdbc:mariadb://localhost:3306/task?user=root&password=12345";

    private DatabaseConnection() {}

    public static Connection getConnection() {
        if(connection != null) {
            return connection;
        }
        else{
            try{
                connection = DriverManager.getConnection(url);
                System.out.println("Connection established.");
                return connection;
            }
            catch (SQLException e) {
                System.out.println("Start Connection failed");
                System.out.println(e.getMessage());
                return null;
            }
        }
    }
    public static void closeConnection() {
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
                System.out.println("connection closed");
            }
        }catch(SQLException e) {
            System.out.println("Closing Connection failed");
        }
    }

}
