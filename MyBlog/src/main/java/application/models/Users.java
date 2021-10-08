package application.models;

import java.time.LocalDateTime;

/**
 * this class is to handle the SQL database 'MyBlog' users table data
 */
public class Users {

    private int userID;
    private String userName;
    private String password;
    private Entitlement entitlement;
    private LocalDateTime registrationTime;
    private byte[] profilePicture;

    public Users() {
    }

    public Users(int userID, String userName, String password, Entitlement entitlement, LocalDateTime registrationTime, byte[] profilePicture) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.entitlement = entitlement;
        this.registrationTime = registrationTime;
        this.profilePicture = profilePicture;
    }
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

    public Users(String userName, Entitlement entitlement) {
        this.userName = userName;
        this.entitlement = entitlement;
    }

    public Users(Users showGivenUserData) {
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Entitlement getEntitlement() {
        return entitlement;
    }

    public void setEntitlement(Entitlement entitlement) {
        this.entitlement = entitlement;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
}
