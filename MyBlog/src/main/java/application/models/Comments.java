package application.models;

import java.sql.Timestamp;

public class Comments {

    private int commentID;
    private String commentText;
    private Timestamp commentTime;
    private Status status;
    private int commenterID;
    private int commentBlogID;
    private int history_comment_ID;

    public Comments() {
    }

    public Comments(int commentID, String commentText, Timestamp commentTime, Status status, int commenterID, int commentBlogID, int history_comment_ID) {
        this.commentID = commentID;
        this.commentText = commentText;
        this.commentTime = commentTime;
        this.status = status;
        this.commenterID = commenterID;
        this.commentBlogID = commentBlogID;
        this.history_comment_ID = history_comment_ID;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCommenterID() {
        return commenterID;
    }

    public void setCommenterID(int commenterID) {
        this.commenterID = commenterID;
    }

    public int getCommentBlogID() {
        return commentBlogID;
    }

    public void setCommentBlogID(int commentBlogID) {
        this.commentBlogID = commentBlogID;
    }

    public int getHistory_comment_ID() {
        return history_comment_ID;
    }

    public void setHistory_comment_ID(int history_comment_ID) {
        this.history_comment_ID = history_comment_ID;
    }
}
