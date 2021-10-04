package application.util;
import application.models.*;
import application.module.*;
import java.util.List;
import java.util.Scanner;

/**
 * this class is for managing the queries:
 * -- directs to the method based on user input
 * -- runs the method selected
 * -- requests parameter needed by method from user
 * -- gives back results
 * -- stores result lists
 * -- stores request text as String
 */
public class QueryManager {

    private String runFirstRequestInput = "Please enter user name you want to see all data";
    private String runSecondRequestInput = "Please enter entitlement you need a list of users";
    private String runThirdRequestInput = "Please enter userName you want to see all of his/her blogposts";
    private String runFourthRequestInput = "Please enter userName you want to see all blogs (s)he created";
    private String runFifthRequestInput = "Please enter blogPostID you want to see all related comments";

    private List<Users> userList;
    private List<BlogPosts> blogPostsList;
    private List<Blog> blogList;
    private List<Comments> commentList;

    GivenUserDataQuery givenUserDataQuery = new GivenUserDataQuery();
    ListAllUsersPerEntitlementQuery listAllUsersPerEntitlementQuery = new ListAllUsersPerEntitlementQuery();
    ListGivenUsersBlogPostsQuery listGivenUsersBlogPostsQuery = new ListGivenUsersBlogPostsQuery();
    ListGivenUsersBlogsQuery listGivenUsersBlogsQuery = new ListGivenUsersBlogsQuery();
    ListAllCommentsOfBlogQuery listAllCommentsOfBlogQuery = new ListAllCommentsOfBlogQuery();

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
        }
    }

    /**
     * this method requests the parameter for the method module.givenUserDataQuery
     * --the user name for giving back all user data of selected user--
     * from the user, then the method gives back the result
     * */
    public void runFirst(){
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println(runFirstRequestInput);
        String runFirstAnswer = scanner.nextLine();

        Users searchUser = givenUserDataQuery.showGivenUserData(runFirstAnswer);
        //TODO System.out.println("See below the given user data");
        System.out.println(searchUser.getUserName() + ", " + searchUser.getUserID() +
                ", " + searchUser.getEntitlement() + ", " + searchUser.getRegistrationTime());
        } catch (Exception e) {
            System.out.println("This User does not exists!");}

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

        userList = listAllUsersPerEntitlementQuery.listAllUsersPerEntitlement(runSecondAnswer);
        //TODO System.out.println("See below the list of users with USER entitlement");
        userList.forEach(users -> System.out.println(users.getUserName() + ", " + users.getUserID() +
                ", " + users.getEntitlement() + ", " + users.getRegistrationTime())) ;
        } catch (Exception e) {
            System.out.println("No such entitlement!" +"\n");}
    }
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

            blogPostsList = listGivenUsersBlogPostsQuery.listGivenUsersBlogPosts(runThirdAnswer);
            //TODO System.out.println("See below the list of blogposts created by given user");
            blogPostsList.forEach(blogPosts -> System.out.println("Blogpost ID: " + blogPosts.getBlogPostID() +", Blogpost name: "
                + blogPosts.getBlogPostName() + ", Blogpost created: "+ blogPosts.getBlogPostTime()));
            } catch (Exception e) {
                System.out.println("WRONG INPUT!" +"\n");}

    }
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

        blogList = listGivenUsersBlogsQuery.listGivenUsersBlogs(runFourthAnswer);
        //TODO System.out.println("See below the list of blogs created by given user");
        blogList.forEach(blog -> System.out.println("Blog name: "
                + blog.getBlogName() + ", Blogpost template name: "+ blog.getBlogTemplateName()
                + ", Blog created: " + blog.getCreationTime()));
        } catch (Exception e) {
            System.out.println("WRONG INPUT!" +"\n");}
    }
    /**
     * this method requests the parameter for the method (module.listAllCommentsOfBlogQuery)
     * --the BlogPostID for giving back all comments related the selected BlogPost--
     * from the user, then the method gives back the result
     * */
    public void runFifth(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println(runFifthRequestInput);
            int runFifthAnswer = scanner.nextInt();

        commentList = listAllCommentsOfBlogQuery.listAllCommentsOfBlogPosts(runFifthAnswer);
        //TODO System.out.println("See below the list of comments arrived on blogPostID given");
        commentList.forEach(comments -> System.out.println("Comment text: "
                + comments.getCommentText() + ", comment time: "+ comments.getCommentTime()
                + ", commenter ID: " + comments.getCommentID() + ", history comments ID: " + comments.getHistory_comment_ID()));
        } catch (Exception e) {
            System.out.println("WRONG INPUT!" +"\n");}
    }
}
