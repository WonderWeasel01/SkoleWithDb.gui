import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;


public class DbSql {

    private Connection connection;
    private Statement stmt;
    private Statement stmt1;



    DbSql() {
        connection = null;
        stmt = null;
        try {
            //Windows
            //String url = "jdbc:sqlite:C:/Users/alexw/IdeaProjects/SkoleWithDb.gui/identifier.sqlite";
            //Mac
            String url = "jdbc:sqlite:/Users/alexwentzel/Documents/1Semester/SkoleDb/identifier.sqlite";
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void alleStuderende() {
        try {
            String sql = "select * from main.Studerende";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            while (rs.next()) {
                System.out.println(rs.getInt("stdnr"));
                System.out.println(rs.getString("fnavn"));
                System.out.println(rs.getString("enavn"));
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}