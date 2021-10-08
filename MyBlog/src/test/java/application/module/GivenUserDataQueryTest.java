package application.module;

import application.models.Entitlement;
import application.models.Users;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class GivenUserDataQueryTest {
    @Test
    public void showGivenUserDataTest(){
        //int userID, String userName, String password, Entitlement entitlement, LocalDateTime registrationTime
    Users expected = new Users(1,
            "PussyCat",
            "taCyssup",
            Entitlement.valueOf("USER"),
            LocalDateTime.of(2021,9,1,1,0,0));

        Assert.assertEquals(expected.getUserID(),GivenUserDataQuery.showGivenUserData("PussyCat").getUserID());
    }

}