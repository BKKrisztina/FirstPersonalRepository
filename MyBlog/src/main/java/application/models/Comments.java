package application.models;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * this class is to handle the SQL database 'MyBlog' comments table data
 */
public class Comments {

    @Getter
    private int commentID;
    @Getter
    private String commentText;
    @Getter
    private LocalDateTime commentTime; // String
    @Getter
    private Status status;
    @Getter
    private int commenterID;
    @Getter
    private int commentBlogID;
    @Getter
    private int history_comment_ID;

    public Comments(int commentID, String commentText, LocalDateTime commentTime, Status status, int commenterID, int commentBlogID, int history_comment_ID) {
        this.commentID = commentID;
        this.commentText = commentText;
        this.commentTime = commentTime;
        this.status = status;
        this.commenterID = commenterID;
        this.commentBlogID = commentBlogID;
        this.history_comment_ID = history_comment_ID;
    }

}
