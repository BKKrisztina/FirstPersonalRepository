package application.module;
import application.database.DBEngine;
import application.models.Entitlement;
import application.models.Users;
import java.sql.*;
import java.time.LocalDateTime;

public class GivenUserDataQuery {
    /**
     * this method handles the query itself, which gives back all of the data of a selected (blog)user
     * util.ScreenManager calls this method
     */

    static DBEngine engine = new DBEngine();

    public static Users showGivenUserData(String searchUser) {

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
                LocalDateTime registrationTime = resultSet.getTimestamp("reg_time").toLocalDateTime();

                result = new Users(userID, userName, password, entitlement, registrationTime);
            }
            //System.out.println("This user have entitlement following: " + result.getEntitlement());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}



