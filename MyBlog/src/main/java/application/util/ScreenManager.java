package application.util;
import application.module.CredentialsMapQuery;
import application.module.GivenUserDataQuery;
import lombok.Getter;
import lombok.Setter;
import java.util.Scanner;

/**
 * this class is for interacting with the user
 * -- stores messages to user
 * -- stores methods requesting user input and direct to next step method
 */

public class ScreenManager {
    @Getter
    public String registeredAnswer;
    @Getter
    public static String usernameEntered;
    @Getter
    public static String passwordEntered;
    @Getter
    public int userOpAnswer;
    @Getter
    public int moderatorOpAnswer;
    @Getter
    public int adminOpAnswer;
    @Getter
    @Setter
    private int attemptCounter = 0;

    private String welcome = "Welcome to myBlog community!";
    private String ifRegistered = "Are you a registered member already?" + "\n" + "Choose Y/N";
    private String attemptLimitPassed = "Attempt limit passed!";
    private static String wrongInput = "WRONG INPUT!";

    public ScreenManager() {
    }

    static QueryManager queryHandler = new QueryManager();
    CredentialsMapQuery credentialsMapQuery = new CredentialsMapQuery();

    public String ifRegistered() {

        Scanner scanner = new Scanner(System.in);
        if (attemptCounter < 4) {
            System.out.println(welcome);
            System.out.println(ifRegistered);
            String registeredAnswer = scanner.nextLine();
            attemptCounter += 1;
            if (registeredAnswer.equalsIgnoreCase("Y")) {
                askUserName();
            } else if (registeredAnswer.equalsIgnoreCase("N")) {
                notRegistered();
            } else {
                System.out.println("Wrong input, try again!" + "\n" +"Attempts left: " +(3-attemptCounter) + "\n");
                ifRegistered();
            }
        } else {
            System.out.println(attemptLimitPassed);
        }
        return registeredAnswer;
    }
    public String askUserName() {
        Scanner scanner = new Scanner(System.in);
        attemptCounter = 0;
        if (attemptCounter < 4) {
            System.out.println("Please enter your Username");
            String usernameEntered = scanner.nextLine();
            attemptCounter += 1;
//TODO nullpointer exception
            try {
                if (credentialsMapQuery.credentialsMap.containsKey(usernameEntered)) {
                    askPassword(usernameEntered);
                } else {
                    wrongUserName();
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                System.out.println("Nullpointer Exception");}
        }else{
        System.out.println(attemptLimitPassed);}
            return usernameEntered;
        }

    public String askPassword(String usernameEntered) {
        Scanner scanner = new Scanner(System.in);
        attemptCounter = 0;
        if (attemptCounter < 4) {
            System.out.println("Please enter your Password");
            String passwordEntered = scanner.nextLine();
            attemptCounter += 1;
            if (credentialsMapQuery.credentialsMap.get(usernameEntered).equals(passwordEntered)) {
                //System.out.println("The key for value " + passwordEntered + " is " + entry.getKey());
                System.out.println("Credentials are ok, you can continue");
                //TODO write method to choose options - entitlementChecker


                GivenUserDataQuery givenUserDataQuery = new GivenUserDataQuery();

                givenUserDataQuery.entitlementChecker(givenUserDataQuery.showGivenUserData(usernameEntered));
               } else {
                    wrongPW();
        }}
        else{
                System.out.println(attemptLimitPassed);}
        return passwordEntered;
    }

    public static int userOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                CHOOSE one of the options below:\s
                3 - Read BlogPosts per user
                4 - Read Blogs per user
                5 - Read Comments of Blog""");
        int userOpAnswer = scanner.nextInt();
        if((userOpAnswer == 3) ||(userOpAnswer == 4) ||(userOpAnswer == 5)){
        queryHandler.querySelector(userOpAnswer);}
        System.out.println(wrongInput);
        return userOpAnswer;
    }

    public static int moderatorOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                CHOOSE one of the options below:\s
                3 - Read BlogPosts per user
                4 - Read Blogs per user
                5 - Read Comments of Blog
                6 - Delete Comments""");
        int moderatorOpAnswer = scanner.nextInt();
        if((moderatorOpAnswer == 3) ||(moderatorOpAnswer == 4) ||(moderatorOpAnswer == 5) ||(moderatorOpAnswer == 6)){
        queryHandler.querySelector(moderatorOpAnswer);}
        System.out.println(wrongInput);
        return moderatorOpAnswer;
    }

    public static int adminOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                CHOOSE one of the options below:\s
                1 - Read all data per user
                3 - Read BlogPosts per user
                2 - List users per entitlement
                4 - Read Blogs per user
                5 - Read Comments of Blog
                6 - Delete Comments""");
        int adminOpAnswer = scanner.nextInt();
        if((adminOpAnswer == 1) ||(adminOpAnswer == 2) ||(adminOpAnswer == 3) ||(adminOpAnswer == 4)
                ||(adminOpAnswer == 5) ||(adminOpAnswer == 6)){
        queryHandler.querySelector(adminOpAnswer);}
//TODO WRONG INPUT -ot mindig kiirja!!!!!
        System.out.println(wrongInput+"\n");
        return adminOpAnswer;
    }

    public void wrongUserName() {

        attemptCounter++;
        System.out.println("This userName is not registered, try again! " +
                "(After the third attempt you will be re-directed to the welcome page)");
        if (attemptCounter < 9) {
            askUserName();
        } else {
            ifRegistered();
        }
    }

    public void wrongPW() {
        attemptCounter++;
        System.out.println("Wrong password, try again! " +
                "(After the third attempt you will be re-directed to the welcome page)");
        if (attemptCounter < 9) {
            askPassword(usernameEntered);
        } else {
            ifRegistered();
        }
    }

    public void notRegistered() {
        attemptCounter++;
        System.out.println("""
                You can continue as visitor, and read blogs, blogposts
                It it so much fun, and you see it's worth to stay and register

                CHOOSE one of the options below:\s
                4 - Read Blogs per user
                3 - Read BlogPosts per user""");
        if(attemptCounter <3){
       try {
            Scanner scanner = new Scanner(System.in);
            int notRegisteredAnswer = scanner.nextInt();

            if (notRegisteredAnswer == 3) {
                queryHandler.querySelector(notRegisteredAnswer);
            } else if (notRegisteredAnswer == 4) {
                queryHandler.querySelector(notRegisteredAnswer);
            }
            System.out.println("Wrong number selected!" + "\n");
            notRegistered();

        } catch (Exception e) {
           System.out.println(wrongInput +"\n");
           notRegistered();}

       }else {
                ifRegistered();
            }
    }
}
