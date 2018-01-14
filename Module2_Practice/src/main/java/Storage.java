

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private String connectionURL = "jdbc:mysql://localhost/Module2_Practice?autoReconnect=true&useSSL=false";
    private String user = "root";
    private String pass = "root";

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public Storage() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTable() throws SQLException {
        String stringQuery = "CREATE TABLE IF NOT EXISTS DEVELOPER" +
                "(ID INT AUTO_INCREMENT PRIMARY KEY," +
                "FIRST_NAME VARCHAR(50)," +
                "LAST_NAME VARCHAR(50)," +
                "SPECIALTY VARCHAR(50))";
        statement.executeUpdate(stringQuery);
    }

    private void createDeveloper(Developer developer) {
        String stringQuery = "INSERT INTO DEVELOPER (FIRST_NAME,LAST_NAME,SPECIALTY) " +
                "VALUES ('"+developer.getFirstName()+"','"+developer.getLastName()+"','"+developer.getSpecialty()+"')";
        System.out.println(stringQuery);

        try {
            statement.executeUpdate(stringQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Developer getDeveloper(long id) {
        String stringQuery = "SELECT * FROM DEVELOPER WHERE ID=" + id;
        try {
            ResultSet resultSet = statement.executeQuery(stringQuery);
            resultSet.next();
            Developer developer = new Developer();
            developer.setId(resultSet.getLong("ID"));
            developer.setFirstName(resultSet.getString("FIRST_NAME"));
            developer.setLastName(resultSet.getString("LAST_NAME"));
            developer.setSpecialty(resultSet.getString("SPECIALTY"));
            return developer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateDeveloper(Developer developer) {
        String sql = "UPDATE DEVELOPER SET " +
                "FIRST_NAME='"+developer.getFirstName()+"', " +
                "LAST_NAME= '"+developer.getLastName()+"'," +
                "SPECIALTY= '"+developer.getSpecialty()+"'" +
                "WHERE  ID="+developer.getId();
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDeveloper(long id) {
        String sql = "DELETE FROM DEVELOPER WHERE ID =" + id;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    List<Developer> listDevelopers() {
        String stringQuery = "SELECT * FROM DEVELOPER";
        List<Developer> developers = new ArrayList<Developer>();
        try {
            ResultSet resultSet = statement.executeQuery(stringQuery);
            while (resultSet.next()) {
                Developer developer = new Developer();
                developer.setId(resultSet.getLong("ID"));
                developer.setFirstName(resultSet.getString("FIRST_NAME"));
                developer.setLastName(resultSet.getString("LAST_NAME"));
                developer.setSpecialty(resultSet.getString("SPECIALTY"));
                developers.add(developer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developers;
    }

    public void addDevelopers(List<Developer> developers) throws SQLException {
        connection.setAutoCommit(false);
        for (Developer i : developers) {
            String stringQuery = "INSERT INTO DEVELOPER (FIRST_NAME,LAST_NAME,SPECIALTY) " +
                    "VALUES ('"+i.getFirstName()+"','"+i.getLastName()+"','"+i.getSpecialty()+"')";
            statement.addBatch(stringQuery);
        }
        statement.executeBatch();
        connection.commit();
    }

    public void clearDatabase() {
        String stringQuery = "TRUNCATE DEVELOPER";
        try {
            statement.executeUpdate(stringQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDeveloperPrepared(Developer developer) {
        String stringQuery = "UPDATE DEVELOPER SET FIRST_NAME=?, LAST_NAME=?,SPECIALTY=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(stringQuery);
            preparedStatement.setString(1,developer.getFirstName());
            preparedStatement.setString(2,developer.getLastName());
            preparedStatement.setString(3,developer.getSpecialty());
            preparedStatement.setLong(4,developer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        Storage storage = new Storage();
        storage.statement = storage.connection.createStatement();
//    CREATE TABLE
        storage.createTable();
//    CREATE DEVELOPER
        storage.createDeveloper(new Developer("Bob","Smith","Java"));
        storage.createDeveloper(new Developer("Paul","Taylor","C++"));
        storage.createDeveloper(new Developer("David","Lewis","Ruby"));
        storage.createDeveloper(new Developer("Mark","Scott","Python"));
//    GET DEVELOPER
        System.out.println(storage.getDeveloper(2).toString());
//    UPDATE DEVELOPER
        storage.updateDeveloper(new Developer(3,"David","Thomas","Java"));
//    DELETE DEVELOPER
        storage.deleteDeveloper(1);
//    GET ALL DEVELOPERS
        for (Developer i : storage.listDevelopers()) {
            System.out.println(i.toString());
        }
//    ADD DEVELOPERS
        List<Developer> developers = new ArrayList<Developer>();
        developers.add(new Developer("Kevin","Lopez","C++"));
        developers.add(new Developer("Brian","Hill","Ruby"));
        developers.add(new Developer("Gary","Adams","Java"));
        storage.addDevelopers(developers);
//    CLEAR DATABASE
        storage.clearDatabase();
//    UPDATE DEVELOPER PREPARED
        storage.updateDeveloperPrepared(new Developer(1,"Bob","Baker","Java"));
    }
}
