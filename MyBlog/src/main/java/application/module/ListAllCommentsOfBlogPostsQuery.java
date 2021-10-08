package application.module;
import application.database.DBEngine;
import application.models.Comments;
import application.models.Status;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListAllCommentsOfBlogPostsQuery {
    /**
     * this method handles the query itself, which gives back all comments of a selected blogPost
     * util.QueryManager calls this method
     */
    static DBEngine engine = new DBEngine();

    public static List<Comments> listAllCommentsOfBlogPosts(int searchBlogPostID) {

        String query = "SELECT * FROM comments JOIN blogposts ON blog_ref_ID = blogposts.blogposts_id WHERE blogposts_id = ?";

        List<Comments> commentList = new ArrayList<>();

        try {
            PreparedStatement ps = engine.connection.prepareStatement(query);
            ps.setInt(1, searchBlogPostID);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int commentID = resultSet.getInt("comment_id");        // resultSet.getLong(1);
                String commentText = resultSet.getString("comment_text");
                LocalDateTime commentTime = resultSet.getTimestamp("comment_time").toLocalDateTime();
                String statusFromDB = resultSet.getString("comment_status");
                Status status = Status.find(statusFromDB);
                int commenterID = resultSet.getInt("commenter_ID");
                int commentBlogID = resultSet.getInt("blog_ref_ID");
                int history_comment_ID = resultSet.getInt("history_comment_ID");

                Comments comment = new Comments (commentID, commentText, commentTime, status, commenterID, commentBlogID, history_comment_ID);

                commentList.add(comment);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return commentList;
    }


}
