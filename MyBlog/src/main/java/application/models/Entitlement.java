package application.models;

/**
 * this enum is for the SQL database 'MyBlog' entitlement enum in users table
 */

public enum Entitlement {

    ADMIN,
    MODERATOR,
    USER,
    VISITOR;

    public static Entitlement find(String name) {
        for (Entitlement entitlement : Entitlement.values()) {
            if (entitlement.toString().equalsIgnoreCase(name)) {
                return entitlement;
            }
        }
        return Entitlement.USER;
    }

    public int getDBIndex() {
        return ordinal() + 1;
    }
}
