package application.util;

import application.database.DBEngine;
import application.models.Entitlement;
import application.models.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GivenUserDataQuery {


    DBEngine engine = new DBEngine();

    public Users showGivenUserData(String searchUser) {

        String query = "SELECT * FROM users WHERE User_name = ?";


        Users result = null;

        try {
            PreparedStatement ps = engine.connection.prepareStatement(query);
            ps.setString(1, searchUser);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int userID = resultSet.getInt("user_id");        // resultSet.getLong(1);
                String userName = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                String entitlementFromDB = resultSet.getString("entitlement");
                Entitlement entitlement = Entitlement.find(entitlementFromDB);
                Timestamp registrationTime = resultSet.getTimestamp("reg_time");

                result = new Users(userID, userName, password, entitlement, registrationTime);
            }
            //System.out.println("This user have entitlement following: " + result.getEntitlement());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void entitlementChecker(Users result) {
        if(result.getEntitlement().toString().equals( "USER")) {
            ScreenManager.userOptions();
        } else if(result.getEntitlement().toString().equals( "MODERATOR")){
            ScreenManager.moderatorOptions();
        } else if(result.getEntitlement().toString().equals( "ADMIN")){
            ScreenManager.adminOptions();
        }else{
            System.out.println("BUG FIX NEEDED");
        }
    }

    public boolean credentialsChecker(Users result, String password) {
        ScreenManager screenManager = new ScreenManager();
        boolean credentials = false;
        if(result.getPassword().equals(password)){
            credentials = true;
            System.out.println("Credentials are ok, you can continue");
        }
        screenManager.wrongPW();
        return credentials;
    }
}
