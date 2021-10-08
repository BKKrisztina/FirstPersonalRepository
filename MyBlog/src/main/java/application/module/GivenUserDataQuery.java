package application.module;
import application.database.DBEngine;
import application.models.Entitlement;
import application.models.Users;
import application.util.ScreenManager;
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

    /**
     * this method uses the result of the method above,
     * checks the entitlement of the user after credentials verification,
     * so then options for next step can be offered to the user
     * util.screenmanager calls this method
     */

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

    public static boolean credentialsChecker(String usernameEntered, String passwordEntered) {
        ScreenManager screenManager = new ScreenManager();
        boolean credentials = false;
        if(showGivenUserData(usernameEntered).getPassword().equals(passwordEntered))
{
            credentials = true;
            System.out.println("Credentials are ok, you can continue");
        }
        //screenManager.wrongPW();
        return credentials;
    }
}
