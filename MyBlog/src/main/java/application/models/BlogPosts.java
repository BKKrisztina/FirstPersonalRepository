package application.models;

import java.sql.Timestamp;

/**
 * this class is to handle the SQL database 'MyBlog' comments table data
 */

public class BlogPosts {

    private int blogPostID;
    private int bloggerID;
    private String blogPostName;
    private Timestamp blogPostTime;
    private String blogText;

    public BlogPosts() {
    }

    public BlogPosts(int blogpostID, int bloggerID, String blogPostName, Timestamp blogPostTime, String blogText) {
        this.blogPostID = blogpostID;
        this.bloggerID = bloggerID;
        this.blogPostName = blogPostName;
        this.blogPostTime = blogPostTime;
        this.blogText = blogText;
    }

    public int getBlogPostID() {
        return blogPostID;
    }

    public void setBlogPostID(int blogPostID) {
        this.blogPostID = blogPostID;
    }

    public int getBloggerID() {
        return bloggerID;
    }

    public void setBloggerID(int bloggerID) {
        this.bloggerID = bloggerID;
    }

    public String getBlogPostName() {return blogPostName;}

    public void setBlogPostName(String blogPostName) {this.blogPostName = blogPostName; }

    public Timestamp getBlogPostTime() {
        return blogPostTime;
    }

    public void setBlogPostTime(Timestamp blogPostTime) {
        this.blogPostTime = blogPostTime;
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }
}
