import dao.DeveloperDAO;
import dao.JDBC.JdbcDeveloperDAOImpl;
import model.Developer;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DeveloperDAO developerDAO = new JdbcDeveloperDAOImpl();
        Developer developer = developerDAO.get(5);
        System.out.println(developer);
    }
}
