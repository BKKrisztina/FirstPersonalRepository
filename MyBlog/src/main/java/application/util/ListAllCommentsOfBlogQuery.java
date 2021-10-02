package application.util;

import application.database.DBEngine;
import application.models.Comments;
import application.models.Entitlement;
import application.models.Status;
import application.models.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ListAllCommentsOfBlogQuery {

    DBEngine engine = new DBEngine();

    public List<Comments> listAllCommentsOfBlog (int searchBlogPostID) {
//SELECT * FROM subjects JOIN subjects2courses ON subjects.id = subjects2courses.subject_id
// WHERE subjects2courses.schedule_day ='saturday' OR subjects2courses.schedule_day ='sunday' ORDER BY schedule_day,schedule_hour;
        String query = "SELECT * FROM comments JOIN blogposts ON blog_ref_ID = blogposts.blogposts_id WHERE blogposts_id = ?";

        List<Comments> commentList = new ArrayList<>();

        try {
            PreparedStatement ps = engine.connection.prepareStatement(query);
            ps.setInt(1, searchBlogPostID);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int commentID = resultSet.getInt("comment_id");        // resultSet.getLong(1);
                String commentText = resultSet.getString("comment_text");
                Timestamp commentTime = resultSet.getTimestamp("comment_time");
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
