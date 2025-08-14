import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public void insertAdmin(String name,String email,String password){

        String query = "INSERT INTO admin(admin_name,admin_email,admin_password)" +
                " VALUES(?,?,?);";

        try{
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.executeUpdate();
            System.out.println("Admin added");
        }catch (SQLException | NullPointerException e) {
            System.out.println("An error occurred while inserting the admin record.");
            System.out.println(e.getMessage());
        }
    }

    public void getAdminById(int id){
        String query = "SELECT admin_name,admin_email FROM admin WHERE admin_id=?;";

        try{
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.print("admin name : ");
                System.out.println(rs.getString("admin_name"));
                System.out.print("admin email : ");
                System.out.println(rs.getString("admin_email"));
            }
            else{
                System.out.println("Admin with id " + id + " does not exist");
            }
        }catch (SQLException | NullPointerException e) {
            System.out.println("An error occurred while get admin record.");
            System.out.println(e.getMessage());
        }
    }

    public void cleanDatabase(){
        try{
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("DELETE FROM admin;");
            ps.executeUpdate();
            System.out.println("database successfully cleaned");
        }catch(SQLException | NullPointerException e) {
            System.out.println("An error occurred while Deleting admin records.");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        DatabaseConnection.getConnection();


        while(true){
            System.out.println("1- Insert admin");
            System.out.println("2- Get admin by id");
            System.out.println("-1 to Exit");

            int choice = sc.nextInt();
            if(choice == 1){
                System.out.print("Enter Admin name : ");
                String name = sc.next();
                System.out.print("Enter Admin email : ");
                String email = sc.next();
                System.out.print("Enter Admin password : ");
                String password = sc.next();

                main.insertAdmin(name,email,password);
            }
            else if(choice == 2){
                System.out.print("Enter admin id : ");
                int id = sc.nextInt();

                main.getAdminById(id);
            }
            else if(choice == -1){
                main.cleanDatabase();
                DatabaseConnection.closeConnection();
                break;
            }
            else{
                System.out.println("Invalid choice");
            }
        }


    }
}
