import application.database.*;
import application.module.CredentialsMapQuery;
import application.util.ScreenManager;

public class Main {
    public static void main(String[] args) {
        //DBEngine engine = new DBEngine();



        ScreenManager screenManager = new ScreenManager();

        //if (engine.isConnected()) {
          //  System.out.println("connected");

            // TODO entitlementMapQuery.entitlementChecker();
            //credentialsMapQuery.buildCredentialsMap();
            screenManager.ifRegistered(0);
            //QueryHandler.runFirst();
        }
    }
//}
