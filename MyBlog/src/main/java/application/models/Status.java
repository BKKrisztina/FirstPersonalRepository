package application.models;

/**
 * this enum is for the SQL database 'MyBlog' status enum in blog_templates table
 */
public enum Status {
    DRAFT,
    PUBLISHED,
    DELETED;

    public static Status find(String name) {
        for (Status status : Status.values()) {
            if (status.toString().equalsIgnoreCase(name)) {
                return status;
            }
        }
        return Status.DRAFT;
    }
}
