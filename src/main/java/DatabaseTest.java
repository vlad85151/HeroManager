import java.sql.*;

public class DatabaseTest {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/RPGHeroManager";
        String user = "postgres";
        String password = "postgres";

        try (Connection connection =
                     DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(
                     "SELECT * FROM heroes")) {

            while (result.next()) {
                System.out.println(
                        result.getString("name") + " | " +
                                result.getInt("hp")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}