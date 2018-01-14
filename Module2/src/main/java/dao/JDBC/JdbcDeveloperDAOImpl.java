package dao.JDBC;

import dao.ConnectionClass;
import dao.DeveloperDAO;
import model.Developer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDeveloperDAOImpl implements DeveloperDAO {

    public void create(Developer developer) throws SQLException {
        String stringQuery = "INSERT INTO developers (name,salary) VALUES ('"+developer.getName()+"',"+developer.getSalary()+")";
        Statement statement = ConnectionClass.getConnection().createStatement();
        statement.executeUpdate(stringQuery);
    }

    public Developer get(int id) throws SQLException {
        String stringQuery = "SELECT * FROM developers WHERE id=" + id;
        Statement statement = ConnectionClass.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(stringQuery);
        Developer developer = new Developer();
        while (resultSet.next()) {
            developer.setId(resultSet.getInt("id"));
            developer.setName(resultSet.getString("name"));
            developer.setSalary(resultSet.getBigDecimal("salary"));
        }
        return developer;
    }

    public void update(Developer developer) {

    }

    public void delete(Developer developer) {

    }
}
