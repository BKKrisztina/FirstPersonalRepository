package application.models;

import java.sql.Timestamp;

public class Blog {

    /**
     * this class is to handle the SQL database 'MyBlog' blogs table data
     */

    private String blogName;
    private int creatorID;
    private Timestamp creationTime;
    private String blogTemplateName;

    public Blog(String blogName, int creatorID, Timestamp creationTime, String blogTemplateName) {
        this.blogName = blogName;
        this.creatorID = creatorID;
        this.creationTime = creationTime;
        this.blogTemplateName = blogTemplateName;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public String getBlogTemplateName() {
        return blogTemplateName;
    }

    public void setBlogTemplateName(String blogTemplateName) {
        this.blogTemplateName = blogTemplateName;
    }
}
