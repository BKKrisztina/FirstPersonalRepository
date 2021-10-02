package application.util;

import application.models.*;


import java.util.List;
import java.util.Scanner;

public class QueryHandler {

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

    public void runFirst(){
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter user name you want to see all data");
        String runFirstAnswer = scanner.nextLine();
        GivenUserDataQuery givenUserDataQuery = new GivenUserDataQuery();
        Users searchUser = givenUserDataQuery.showGivenUserData(runFirstAnswer);
        //TODO System.out.println("See below the given user data");
        System.out.println(searchUser.getUserName() + ", " + searchUser.getUserID() +
                ", " + searchUser.getEntitlement() + ", " + searchUser.getRegistrationTime());
        } catch (Exception e) {
            System.out.println("This User does not exists!");}

        }
    public void runSecond(){
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter entitlement you need a list of users");
        String runSecondAnswer = scanner.nextLine();
        ListAllUsersPerEntitlementQuery listAllUsersPerEntitlementQuery = new ListAllUsersPerEntitlementQuery();
        List<Users> userList = listAllUsersPerEntitlementQuery.listAllUsersPerEntitlement(runSecondAnswer);
        //TODO System.out.println("See below the list of users with USER entitlement");
        userList.forEach(users -> System.out.println(users.getUserName() + ", " + users.getUserID() +
                ", " + users.getEntitlement() + ", " + users.getRegistrationTime())) ;
        } catch (Exception e) {
            System.out.println("No such entitlement!" +"\n");}
    }
    public void runThird(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter userName you want to see all of his/her blogposts");
            String runThirdAnswer = scanner.nextLine();
            ListGivenUsersBlogPostsQuery listGivenUsersBlogPostsQuery = new ListGivenUsersBlogPostsQuery();
            List<BlogPosts> blogPostsList = listGivenUsersBlogPostsQuery.listGivenUsersBlogPosts(runThirdAnswer);
            //TODO System.out.println("See below the list of blogposts created by given user");
            blogPostsList.forEach(blogPosts -> System.out.println("Blogpost ID: " + blogPosts.getBlogPostID() +", Blogpost name: "
                + blogPosts.getBlogPostName() + ", Blogpost created: "+ blogPosts.getBlogPostTime()));
            } catch (Exception e) {
                System.out.println("WRONG INPUT!" +"\n");}

    }
    public void runFourth(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter userName you want to see all blogs (s)he created");
            String runFourthAnswer = scanner.nextLine();
        ListGivenUsersBlogsQuery listGivenUsersBlogsQuery = new ListGivenUsersBlogsQuery();
        List<Blog> blogList = listGivenUsersBlogsQuery.listGivenUsersBlogs(runFourthAnswer);
        //TODO System.out.println("See below the list of blogs created by given user");
        blogList.forEach(blog -> System.out.println("Blog name: "
                + blog.getBlogName() + ", Blogpost template name: "+ blog.getBlogTemplateName()
                + ", Blog created: " + blog.getCreationTime()));
        } catch (Exception e) {
            System.out.println("WRONG INPUT!" +"\n");}
    }

    public void runFifth(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter blogPostID you want to see all related comments");
            int runFifthAnswer = scanner.nextInt();
        ListAllCommentsOfBlogQuery listAllCommentsOfBlogQuery = new ListAllCommentsOfBlogQuery();
        List<Comments> commentList = listAllCommentsOfBlogQuery.listAllCommentsOfBlog(runFifthAnswer);
        //TODO System.out.println("See below the list of comments arrived on blogPostID given");
        commentList.forEach(comments -> System.out.println("Comment text: "
                + comments.getCommentText() + ", comment time: "+ comments.getCommentTime()
                + ", commenter ID: " + comments.getCommentID() + ", history comments ID: " + comments.getHistory_comment_ID()));
        } catch (Exception e) {
            System.out.println("WRONG INPUT!" +"\n");}
    }
}
