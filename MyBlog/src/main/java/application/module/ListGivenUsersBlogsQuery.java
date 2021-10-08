package application.module;
import application.database.DBEngine;
import application.models.Blog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListGivenUsersBlogsQuery {
    /**
     * this method handles the query itself, which gives back all of the blogs created by a selected (blog)user
     * util.QueryManager calls this method
     */

    static DBEngine engine = new DBEngine();

    public static List<Blog> listGivenUsersBlogs(String searchUser) {


        String query = "SELECT * FROM blog JOIN users ON creator_ID = users.user_id WHERE users.User_name = ?";

        List<Blog> blogList = new ArrayList<>();

        try {
            PreparedStatement ps = engine.connection.prepareStatement(query);
            ps.setString(1, searchUser);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String blogName = resultSet.getString("blog_name");
                int creatorID = resultSet.getInt("creator_ID");
                LocalDateTime creationTime = resultSet.getTimestamp("creation_time").toLocalDateTime();
                String blogTemplateName = resultSet.getString("blog_template_name");

                Blog blog = new Blog(blogName, creatorID, creationTime, blogTemplateName);

                blogList.add(blog);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return blogList;
    }

}
