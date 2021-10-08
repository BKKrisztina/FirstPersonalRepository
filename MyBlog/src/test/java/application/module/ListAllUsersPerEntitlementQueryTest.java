package application.module;

import application.models.BlogPosts;
import application.models.Entitlement;
import application.models.Users;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import java.util.Arrays;
import java.util.List;


//int userID, String userName, String password, Entitlement entitlement, LocalDateTime registrationTime
public class ListAllUsersPerEntitlementQueryTest {

    @Test
    public void listAllUsersPerEntitlementQueryTest () {
        //BlackSheep, 13, ADMIN, 2021-09-01T01:00
        List<Users> expectedUsers = Arrays.asList(
                new Users (
                        13,
                      "BlackSheep",
                      "peehSkcalb",
                        Entitlement.valueOf("ADMIN"),
                        LocalDateTime.of(2021,9,1,1,0)
                )
        );
        List<Users> actualUsers = ListAllUsersPerEntitlementQuery.listAllUsersPerEntitlement("admin");

        Assert.assertTrue(compareLists(expectedUsers,actualUsers));

    }

    private boolean compareLists(List<Users> expected, List<Users> actual) {
        if (!(actual != null && expected.size() == actual.size()))
            return false;
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).getEntitlement().equals(actual.get(i).getEntitlement()))
                return false;
        }
        return true;
    }
}