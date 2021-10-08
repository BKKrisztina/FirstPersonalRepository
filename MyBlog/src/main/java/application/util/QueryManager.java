package application.util;

import application.models.Blog;
import application.models.BlogPosts;
import application.models.Comments;
import application.models.Users;
import application.module.*;

import java.util.List;
import java.util.Scanner;

/**This class
 *
 * -- runs the method selected
 * -- requests parameter needed by method from user
 * -- gives back results
 * -- stores request text as String
 */
public class QueryManager {

    private String runFirstRequestInput = "Please enter user name you want to see all data"+ "\n" +
            "choose one of these: PussyCat, PuppyDog, PorkyPig, PinkPanther, DaffyDuck, HoneyBunny, " +
            "MickeyMouse, CharlieBrown, FredFlintstone, SpongeBobSquarePants, KennyMcCormick, WhiteSheep, BlackSheep";
    private String runSecondRequestInput = "Please enter entitlement (USER/ MODERATOR/ ADMIN) you need a list of users";
    private String runThirdRequestInput = "Please enter userName you want to see all of his/her blogposts"+ "\n" +
            "choose one of these: PussyCat, PuppyDog, PorkyPig, PinkPanther, DaffyDuck, HoneyBunny, " +
            "MickeyMouse, CharlieBrown, FredFlintstone, SpongeBobSquarePants, KennyMcCormick, WhiteSheep, BlackSheep";;
    private String runFourthRequestInput = "Please enter userName you want to see all blogs (s)he created"+ "\n" +
            "choose one of these: PussyCat, PuppyDog, PorkyPig, PinkPanther, DaffyDuck, HoneyBunny, " +
            "MickeyMouse, CharlieBrown, FredFlintstone, SpongeBobSquarePants, KennyMcCormick, WhiteSheep, BlackSheep";
    private String runFifthRequestInput = "Please enter blogPostID (1/2/3/4/5/6) you want to see all related comments";
    private String notRegisteredUser = "This is not a registered user name" +"\n";
    private String attemptPassed = "Attempt limit passed. Goodbye!";

    CredentialsMapQuery credentialsMapQuery = new CredentialsMapQuery();

    Users myUsers;

    /**
     *this method is responsible to direct to the method to run based on the users input
     */

    public void querySelector(int queryNumber){
        switch (queryNumber) {
            case 1 -> //"Given user data query"
                    runFirst();
            case 2 -> //"List All Users Per Entitlement Query"
                    runSecond();
            case 3 -> // " List Given Users BlogPosts Query"
                    runThird();
            case 4 -> //"List Given Users Blogs Query"
                    runFourth();
            case 5 -> //"list All Comments Of Blog Query"
                    runFifth();
            case 6 -> //TODO not written yet
                    runSixth();
        }
    }

    /**
     * this method requests the parameter for the method module.givenUserDataQuery
     * --the user name for giving back all user data of selected user--
     * from the user, then the method gives back the result
     * */
    public void runFirst(){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(runFirstRequestInput);
                String runFirstAnswer = scanner.nextLine();
                if (credentialsMapQuery.credentialsMap.containsKey(runFirstAnswer)) {
                    Users searchUser = GivenUserDataQuery.showGivenUserData(runFirstAnswer);
                    System.out.println(searchUser.getUserName() + ", " + searchUser.getUserID() +
                            ", " + searchUser.getEntitlement() + ", " + searchUser.getRegistrationTime());
                    nextQuery();
                } else {
                    System.out.println(notRegisteredUser);
                    runFirst();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    /**
     * this method requests the parameter for the method (module.listAllUsersPerEntitlementQuery)
     * --the entitlement for giving back a list of all users having the selected entitlement--
     * from the user, then the method gives back the result
     * */

    public void runSecond(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println(runSecondRequestInput);
            String runSecondAnswer = scanner.nextLine();
            List<Users> userList = ListAllUsersPerEntitlementQuery.listAllUsersPerEntitlement(runSecondAnswer);
            if(runSecondAnswer.equalsIgnoreCase("user")||runSecondAnswer.equalsIgnoreCase("admin")
                    ||runSecondAnswer.equalsIgnoreCase("moderator")) {
                userList.forEach(users -> System.out.println(users.getUserName() + ", " + users.getUserID() +
                        ", " + users.getEntitlement() + ", " + users.getRegistrationTime()));
                nextQuery();
            }else{
                System.out.println("This entitlement does not exist");
                System.out.println("""
                CHOOSE one of the options below:\s
                USER
                MODERATOR
                ADMIN""");
                runSecond();
            }
        } catch (Exception e) {
            e.printStackTrace();}}

    /**
     * this method requests the parameter for the method (module.listGivenUsersBlogPostsQuery)
     * --the user name for giving back all comment from the selected user--
     * from the user, then the method gives back the result
     * */
    public void runThird(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println(runThirdRequestInput);
            String runThirdAnswer = scanner.nextLine();
            List<BlogPosts> blogPostsList = ListGivenUsersBlogPostsQuery.listGivenUsersBlogPosts(runThirdAnswer);
            if(credentialsMapQuery.credentialsMap.containsKey(runThirdAnswer)) {
                if(blogPostsList.size()!=0){
                    blogPostsList.forEach(blogPosts -> System.out.println("Blogpost ID: " + blogPosts.getBlogPostID() + ", Blogpost name: "
                            + blogPosts.getBlogPostName() + ", Blogpost created: " + blogPosts.getBlogPostTime()));
                }else{
                    System.out.println(runThirdAnswer +" user does not created any blogs!");
                }
                nextQuery();
            }else{
                System.out.println(notRegisteredUser);
                runThird();
            }
       }
        catch (Exception e) {
            e.printStackTrace();}}
    /**
     * this method requests the parameter for the method (module.listGivenUsersBlogsQuery)
     * --the user name for giving back all blogs created by the selected user--
     * from the user, then the method gives back the result
     * */
    public void runFourth(){

        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println(runFourthRequestInput);
            String runFourthAnswer = scanner.nextLine();
            List<Blog> blogList = ListGivenUsersBlogsQuery.listGivenUsersBlogs(runFourthAnswer);
            if(credentialsMapQuery.credentialsMap.containsKey(runFourthAnswer)){
                if(blogList.size()!=0){
                    blogList.forEach(blog -> System.out.println("Blog name: "
                            + blog.getBlogName() + ", Blogpost template name: "+ blog.getBlogTemplateName()
                            + ", Blog created: " + blog.getCreationTime()));
                    nextQuery();
                }else{
                    System.out.println(runFourthAnswer +" user does not created any blogs!");
                }}else{
                System.out.println(notRegisteredUser);
                runFourth();
            }
        } catch (Exception e) {
            e.printStackTrace();}}

    /**
     * this method requests the parameter for the method (module.listAllCommentsOfBlogQuery)
     * --the BlogPostID for giving back all comments related the selected BlogPost--
     * from the user, then the method gives back the result
     * */
    public void runFifth() {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(runFifthRequestInput);
                int runFifthAnswer = scanner.nextInt();
                List<Comments> commentList = ListAllCommentsOfBlogPostsQuery.listAllCommentsOfBlogPosts(runFifthAnswer);
                //TODO System.out.println("See below the list of comments arrived on blogPostID given");
                if (commentList.size() != 0) {
                    commentList.forEach(comments -> System.out.println("Comment text: "
                            + comments.getCommentText() + ", comment time: " + comments.getCommentTime()
                            + ", commenter ID: " + comments.getCommentID() + ", history comments ID: "
                            + comments.getHistory_comment_ID()));
                    nextQuery();
                } else {
                    System.out.println("No comments arrived to this blog post!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    /**
     * not written yet
     * and many more to be written...
     */
        public void runSixth(){
            System.out.println("Under construction");
            nextQuery();
        }

    /**
     * these methods calls re-direct to the methods which offer the available options based on the user entitlement
     */
    public void nextQuery() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("New query? Y/N");
        String nextQuery = scanner.nextLine();
        if (nextQuery.equalsIgnoreCase("Y")) {
            if (myUsers.getEntitlement().toString().equalsIgnoreCase("USER")) {
                ScreenManager.userOptions();
            } else if (myUsers.getEntitlement().toString().equalsIgnoreCase("MODERATOR")) {
                ScreenManager.moderatorOptions();
            } else if (myUsers.getEntitlement().toString().equalsIgnoreCase("ADMIN")) {
                ScreenManager.adminOptions(0);
            } else {
             new ScreenManager().notRegistered();
            }
        }else{
            System.out.println("Goodbye!");
        }
    }
}
