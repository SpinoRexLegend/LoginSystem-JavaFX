import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class LoadThisFirst
{
    public static void main(String[] args)
    {
        try
        {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/login",
                    "root",
                    "Dps3!2006"
            );
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE loginTable(UserName VARCHAR(100) PRIMARY KEY, Password Varchar(50) NOT_NUll)");

            statement.executeUpdate("INSERT INTO loginTable VALUES ('SpinoRexLegend', 'Password')");
            System.out.println("Succesfully updated...");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}

