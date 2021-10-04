package application.module;

import application.database.DBEngine;
import application.models.BlogPosts;
import application.models.Entitlement;
import application.models.Users;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class ListGivenUsersBlogPostsQuery {
    /**
     * this method handles the query itself, which gives back all of the bog posts created by a selected (blog)user
     * util.QueryManager calls this method
     */
    DBEngine engine = new DBEngine();

    public List<BlogPosts> listGivenUsersBlogPosts(String searchUser) {
//SELECT * FROM subjects JOIN subjects2courses ON subjects.id = subjects2courses.subject_id
// WHERE subjects2courses.schedule_day ='saturday' OR subjects2courses.schedule_day ='sunday' ORDER BY schedule_day,schedule_hour;

        String query = "SELECT * FROM blogposts JOIN users ON blogger_ID = users.user_id WHERE users.User_name = ?";

        List<BlogPosts> blogPostList = new ArrayList<>();

        try {
            PreparedStatement ps = engine.connection.prepareStatement(query);
            ps.setString(1, searchUser);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int blogpostID = resultSet.getInt("blogposts_ID");        // resultSet.getLong(1);
                int bloggerID = resultSet.getInt("blogger_ID");
                String blogPostName = resultSet.getString("blog_post_name");
                Timestamp blogPostTime = resultSet.getTimestamp("blog_post_time");
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
