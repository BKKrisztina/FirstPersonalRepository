package application.util;

import application.database.DBEngine;

import application.models.Users;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class CredentialsMapQuery {

    DBEngine engine = new DBEngine();

    @Getter
    @Setter
    public HashMap<String,String> credentialsMap;

    public CredentialsMapQuery() {
        buildCredentialsMap();
    }

    public HashMap<String,String> buildCredentialsMap() {

        String query = "SELECT user_name, password FROM users";


        credentialsMap = new HashMap<>();

        try {
            Statement statement = engine.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String userName = resultSet.getString("user_name");
                String password = resultSet.getString("password");

                Users users = new Users(userName,password);
                credentialsMap.put(users.getUserName(), users.getPassword());
            }
            //System.out.println(credentialsMap.get("PussyCat"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, String> entry : credentialsMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());}
        return credentialsMap;
    }
}

