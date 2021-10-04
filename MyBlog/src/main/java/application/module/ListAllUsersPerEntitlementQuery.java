package application.module;

import application.database.DBEngine;
import application.models.Entitlement;
import application.models.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListAllUsersPerEntitlementQuery {

    /**
     * this method handles the query itself, which gives back a list of users per selected entitlement(user/moderator/admin)
     */

    DBEngine engine = new DBEngine();

    public List<Users> listAllUsersPerEntitlement(String searchEntitlement) {

        String query = "SELECT * FROM users WHERE Entitlement = ?";


        List<Users> userList = new ArrayList<>();

        try {
            PreparedStatement ps = engine.connection.prepareStatement(query);
            ps.setString(1, searchEntitlement);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int userID = resultSet.getInt("user_id");        // resultSet.getLong(1);
                String userName = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                String entitlementFromDB = resultSet.getString("entitlement");
                Entitlement entitlement = Entitlement.find(entitlementFromDB);
                Timestamp registrationTime = resultSet.getTimestamp("reg_time");

                Users user = new Users (userID, userName, password, entitlement, registrationTime);

                userList.add(user);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

}
