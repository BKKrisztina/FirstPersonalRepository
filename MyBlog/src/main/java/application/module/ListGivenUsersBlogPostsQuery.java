package application.module;
import application.database.DBEngine;
import application.models.BlogPosts;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ListGivenUsersBlogPostsQuery {
    /**
     * this method handles the query itself, which gives back all of the bog posts created by a selected (blog)user
     * util.QueryManager calls this method
     */
    static DBEngine engine = new DBEngine();

    public static List<BlogPosts> listGivenUsersBlogPosts(String searchUser) {

        String query = "SELECT * FROM blogposts JOIN users ON blogger_ID = users.user_id WHERE users.User_name = ?";

        List<BlogPosts> blogPostList = new ArrayList<>();

        try {
            PreparedStatement ps = engine.connection.prepareStatement(query);
            ps.setString(1, searchUser);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int blogpostID = resultSet.getInt("blogposts_ID");
                int bloggerID = resultSet.getInt("blogger_ID");
                String blogPostName = resultSet.getString("blog_post_name");
                LocalDateTime blogPostTime = resultSet.getTimestamp("blog_post_time").toLocalDateTime();
                String blogText = resultSet.getString("blog_text");

                BlogPosts blogPosts = new BlogPosts(blogpostID, bloggerID, blogPostName, blogPostTime,blogText);

                blogPostList.add(blogPosts);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return blogPostList;
    }

}
