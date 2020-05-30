import java.sql.*;

public class JdbcDao {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/fx_registrations?useSSL=false";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "root";
    private static final String INSERT_QUERY = "INSERT INTO registration (full_name, email_id, password) VALUES (?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM registration WHERE email_id = ? and password = ?";


    public boolean validate(String email,String password){

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            System.out.println("prepared statement::" + preparedStatement);

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }

        } catch (SQLException e) {
            //todo: put alert with message
            System.out.println(e.getMessage() + e.getSQLState() + e.getErrorCode());
        }

        return false;
    }


    public void insertData(String name, String email, String password) throws SQLException {

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            System.out.println("prepared statement::" + preparedStatement);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            //todo: put alert with message
            System.out.println(e.getMessage() + e.getSQLState() + e.getErrorCode());
        }


    }


}
