package core;

import lombok.Getter;

import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

@Getter
public class DataBase {
    private Statement statement;
    private Connection connection;

    public DataBase() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/expedia_data", "root", "");
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<String> getNameOfHotel() throws ClassNotFoundException, SQLException {
        DataBase dataBase = new DataBase();
        List<String> data = new ArrayList<String>();

        ResultSet q = dataBase.getStatement().executeQuery("SELECT NameHotel FROM ExpediaTable");

        while (q.next()){
            System.out.println(q.getString(1));
            data.add(q.getString(1));
        }

        return data;
    }

}
