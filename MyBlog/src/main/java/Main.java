import application.database.*;
import application.util.CredentialsMapQuery;
import application.util.ScreenManager;

public class Main {
    public static void main(String[] args) {
        DBEngine engine = new DBEngine();
        CredentialsMapQuery credentialsMapQuery = new CredentialsMapQuery();


        ScreenManager screenManager = new ScreenManager();

        if (engine.isConnected()) {
            System.out.println("connected");

            // TODO entitlementMapQuery.entitlementChecker();
            //credentialsMapQuery.buildCredentialsMap();
            screenManager.ifRegistered();
            //QueryHandler.runFirst();
        }
    }
}
