package application.util;
import application.models.Users;
import lombok.Getter;

import java.util.InputMismatchException;
import java.util.Scanner;
import static application.module.GivenUserDataQuery.showGivenUserData;

/**
 * this class is for interacting with the user
 * -- stores messages to user
 * -- stores methods requesting user input and direct to next step method
 */

public class ScreenManager {

    @Getter
    public Users myUsers;
    @Getter
    public String registeredAnswer;
    @Getter
    public String usernameEntered;
    @Getter
    public String passwordEntered;


    private String welcome = "Welcome to myBlog community!";
    private String ifRegistered = "Are you a registered member already?" + "\n" + "Choose Y/N";
    private String attemptLimitPassed = "Attempt limit passed!";
    private static String wrongInput = "WRONG INPUT!";
    private String messageToNotRegistered = """
                You can continue as visitor, and read blogs, blogposts
                It it so much fun, and you see it's worth to stay and register

                CHOOSE one of the options below:\s
                4 - Read Blogs per user
                3 - Read BlogPosts per user""";

    public ScreenManager() {
    }

    static QueryManager queryHandler = new QueryManager();

    public Users ifRegistered(int attemptCounter) {
    if(attemptCounter < 3){
            Scanner scanner = new Scanner(System.in);
            System.out.println(welcome);
            System.out.println(ifRegistered);
            String registeredAnswer = scanner.nextLine();

            if (registeredAnswer.equalsIgnoreCase("Y")) {
                askUserName();
            } else if (registeredAnswer.equalsIgnoreCase("N")) {
                notRegistered();
            } else {
                System.out.println("Wrong input, try again!");
                attemptCounter++;
                ifRegistered(attemptCounter);
            }
        } else {
            System.out.println("Attempt limit passed!");
        }
        return myUsers;
    }

    public void askUserName() {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your Username");
            String usernameEntered = scanner.nextLine();
          myUsers = showGivenUserData(usernameEntered);
          queryHandler.myUsers = myUsers;
        System.out.println(myUsers.getUserName() +","+ myUsers.getPassword()+","+myUsers.getEntitlement());
            try {
                if (myUsers.getUserName().equalsIgnoreCase(usernameEntered)){
                    askPassword(myUsers,0);
                } else {
                    wrongUserName(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public void askPassword(Users myUsers,int attemptCounter){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your Password");
        String passwordEntered = scanner.nextLine();
        if(myUsers.getPassword().equals(passwordEntered)){
            System.out.println("Credentials are ok, you can continue");
            if(myUsers.getEntitlement().toString().equals("USER")) {
                userOptions();
            }else if(myUsers.getEntitlement().toString().equals("MODERATOR")) {
                moderatorOptions();
            }else{
                adminOptions(0);
            }
        }else {
        wrongPW(myUsers,attemptCounter);
    }
}
    public static void userOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                CHOOSE one of the options below:\s
                3 - Read BlogPosts per user
                4 - Read Blogs per user
                5 - Read Comments of Blog""");
        int userOpAnswer = scanner.nextInt();
        if ((userOpAnswer == 3) || (userOpAnswer == 4) || (userOpAnswer == 5)) {
            queryHandler.querySelector(userOpAnswer);
        } else {
            System.out.println(wrongInput);
        }
    }

    public static void moderatorOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                CHOOSE one of the options below:\s
                3 - Read BlogPosts per user
                4 - Read Blogs per user
                5 - Read Comments of Blog
                6 - Delete Comments""");
        int moderatorOpAnswer = scanner.nextInt();
        if ((moderatorOpAnswer == 3) || (moderatorOpAnswer == 4) || (moderatorOpAnswer == 5) || (moderatorOpAnswer == 6)) {
            queryHandler.querySelector(moderatorOpAnswer);
        } else {
            System.out.println(wrongInput);
        }
    }

    public static void adminOptions(int attemptCounter) {
        if (attemptCounter < 3) {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    CHOOSE one of the options below:\s
                    1 - Read all data per user
                    2 - List users per entitlement
                    3 - Read BlogPosts per user
                    4 - Read Blogs per user
                    5 - Read Comments of Blog
                    6 - Delete Comments""");
            int adminOpAnswer = scanner.nextInt();
            if ((adminOpAnswer == 1) || (adminOpAnswer == 2) || (adminOpAnswer == 3) || (adminOpAnswer == 4)
                    || (adminOpAnswer == 5) || (adminOpAnswer == 6)) {
                queryHandler.querySelector(adminOpAnswer);
            } else {
                System.out.println(wrongInput + "\n");
                attemptCounter++;
                ScreenManager.adminOptions(attemptCounter);
            }}catch (InputMismatchException e){
            System.out.println(wrongInput + "\n");
        }}
        else {
            attemptCounter++;
            System.out.println("Attempt limit passed!");
        }}

    public void wrongUserName(int attemptCounter) {

        if (attemptCounter < 3) {
            System.out.println("This userName is not registered, try again! " +
                    "(You will be re-directed to the welcome page)");
           ifRegistered(attemptCounter);
       } else {
            System.out.println(attemptLimitPassed);
        }
    }

    public void wrongPW(Users myUsers,int attemptCounter) {
        attemptCounter++;
        if (attemptCounter < 3) {
            System.out.println("Wrong password, try again! " +
                    "(You have 3 attempts, then exits)");
            askPassword(myUsers,attemptCounter);
        } else {
            System.out.println(attemptLimitPassed);
        }
    }

    public void notRegistered() {
        System.out.println(messageToNotRegistered);
        try {
            Scanner scanner = new Scanner(System.in);
            int notRegisteredAnswer = scanner.nextInt();
            if (notRegisteredAnswer == 3) {
                queryHandler.querySelector(notRegisteredAnswer);
            } else if (notRegisteredAnswer == 4) {
                queryHandler.querySelector(notRegisteredAnswer);
            } else {
                System.out.println("Wrong number selected!" + "\n");
                notRegistered();
            }
        } catch (InputMismatchException e) {
            System.out.println(wrongInput);
        }
    }
}
