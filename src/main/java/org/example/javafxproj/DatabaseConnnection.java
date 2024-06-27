package org.example.javafxproj;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "questions";
        String databaseUser = "root";
        String databasePassword = "huyhuyhuy1312";
        String url = "jdbc:mysql://localhost/" + databaseName;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
}
