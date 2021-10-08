package application.module;
import application.models.Blog;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

class ListGivenUsersBlogsQueryTest {

    @Test
    public void listGivenUsersBlogsTest() {
        List<Blog> expectedBlogs = Arrays.asList(
                new Blog(
                        "kiddo",
                        1,
                        LocalDateTime.of(2021, 9, 27, 21, 8, 14),
                        "colorful"
                )
        );
        List<Blog> actualBlogs = ListGivenUsersBlogsQuery.listGivenUsersBlogs("PussyCat");
        Assert.assertTrue(compareLists(expectedBlogs, actualBlogs));
    }

    private boolean compareLists(List<Blog> expected, List<Blog> actual) {
        if (!(actual != null && expected.size() == actual.size()))
            return false;
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).getBlogName().equals(actual.get(i).getBlogName()))
                return false;
        }
        return true;
    }
}