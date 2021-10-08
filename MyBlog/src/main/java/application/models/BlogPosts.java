package application.models;

import lombok.Getter;

import java.sql.Time;
import java.time.LocalDateTime;

/**
 * this class is to handle the SQL database 'MyBlog' comments table data
 */

public class BlogPosts {

    @Getter
    private int blogPostID;
    @Getter
    private int bloggerID;
    @Getter
    private String blogPostName;
    @Getter
    private LocalDateTime blogPostTime;
    @Getter
    private String blogText;

    public BlogPosts(int blogpostID, int bloggerID, String blogPostName, LocalDateTime blogPostTime, String blogText) {
        this.blogPostID = blogpostID;
        this.bloggerID = bloggerID;
        this.blogPostName = blogPostName;
        this.blogPostTime = blogPostTime;
        this.blogText = blogText;
    }

}
