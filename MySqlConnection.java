import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class MySqlConnection{
    public static void main(String[] args){
        Properties props = new Properties();
        try (InputStream input = MySqlConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println("Unable to find db.properties");
                return;
            }
            props.load(input);

            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");

            // Read data from user input
            Scanner scanner = new Scanner(System.in);

            // Prompt user for details
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  

            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();  

            System.out.print("Enter Income: ");
            int income = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter Address: ");
            String address = scanner.nextLine();

            // Prepare SQL statement
            String query = "INSERT INTO employee (id, first_name, last_name, age, income, address) VALUES (?, ?, ?, ?, ?, ?)";

            // Use PreparedStatement to avoid SQL injection and set parameters
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setInt(4, age);
            stmt.setInt(5, income);
            stmt.setString(6, address);

            // Execute the insert query
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new employee was inserted successfully!");
            }

            // Close the connection and scanner
            conn.close();
            scanner.close();

        } catch (IOException | ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
 
