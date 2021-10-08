package application.models;

import lombok.Getter;
import java.time.LocalDateTime;

public class Blog {

    /**
     * this class is to handle the SQL database 'MyBlog' blogs table data
     */
    @Getter
    private String blogName;
    @Getter
    private int creatorID;
    @Getter
    private LocalDateTime creationTime;
    @Getter
    private String blogTemplateName;

    public Blog(String blogName, int creatorID, LocalDateTime creationTime, String blogTemplateName) {
        this.blogName = blogName;
        this.creatorID = creatorID;
        this.creationTime = creationTime;
        this.blogTemplateName = blogTemplateName;
    }

}
