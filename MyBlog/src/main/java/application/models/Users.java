package application.models;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * this class is to handle the SQL database 'MyBlog' users table data
 */
public class Users {

    @Getter
    private int userID;
    @Getter
    private String userName;
    @Getter
    private String password;
    @Getter
    private Entitlement entitlement;
    @Getter
    private LocalDateTime registrationTime;
    @Getter
    private byte[] profilePicture;

    public Users(int userID, String userName, String password, Entitlement entitlement, LocalDateTime registrationTime) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.entitlement = entitlement;
        this.registrationTime = registrationTime;
    }

    public Users(String userName,String password) {
        this.userName = userName;
        this.password = password;
    }
}
