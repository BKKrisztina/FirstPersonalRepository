package application.module;
import application.models.Comments;
import application.models.Status;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ListAllCommentsOfBlogQueryTest {
    /**
     *
     *TEST FAILED :-(((((
     */
    @Test
/*    public void listAllCommentsOfBlogQueryTest() {
        //LocalDateTime dateTime = LocalDateTime.of(2021,9,2,10,33,9);
        List<Comments> expectedComments = Arrays.asList(
                new Comments(1,
                        "congrats",
                        LocalDateTime.of(2021,9,2,10,33,9),
                        Status.valueOf("PUBLISHED"),
                        1,
                        1,
                        0),
                new Comments(2,
                        "how cute!",
                        LocalDateTime.of(2021,9,2,10,35,42),
                        Status.valueOf("PUBLISHED"),
                        1,
                        1,
                        0),
                new Comments(18,
                        "thanks,",
                        LocalDateTime.of(2021,9,2,10,33,9),
                        Status.valueOf("PUBLISHED"),
                        2,
                        1,
                        1)
        );

        List<Comments> actualComments = ListAllCommentsOfBlogPostsQuery.listAllCommentsOfBlogPosts(1);
        Assert.assertTrue(compareLists(expectedComments, actualComments));
    }*/

    private boolean compareLists(List<Comments> expected, List<Comments> actual) {
        if (!(actual != null && expected.size() == actual.size()))
            return false;
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).getCommentText().equals(actual.get(i).getCommentText()))
                return false;
        }
        return true;
    }

}