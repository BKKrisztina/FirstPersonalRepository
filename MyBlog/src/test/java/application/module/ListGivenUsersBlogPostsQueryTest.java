package application.module;

import application.models.BlogPosts;
import application.models.Users;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListGivenUsersBlogPostsQueryTest {

    @Test
    public void listGivenUsersBlogPostsTest() {
        List<BlogPosts> expectedBlogPosts = Arrays.asList(
                new BlogPosts(
                        1,
                        1,
                        "kiddo",
                        LocalDateTime.of(2021, 9, 1, 00, 00, 00),
                        "From day one of wanting to conceive, Ive always owned the belief " +
                                "of trusting my body and trusting the timing of my life. " +
                                "I’ve held faith that my body would do what it was supposed to do when the timing was right. " +
                                "Becoming pregnant was something I’ve always dreamed of but to be honest with you, " +
                                "scared me a little. I never really came across positive birth stories, " +
                                "only ones that warned of labor and delivery perils. Each labor is different, " +
                                "just as every pregnancy is different and I think it’s incredibly important " +
                                "for all stories to be shared. My story is deeply personal and I’m choosing to share " +
                                "in hopes to encourage pregnancy optimism through my positive birthing experience."
                )
        );
        List<BlogPosts> actualBlogPosts = ListGivenUsersBlogPostsQuery.listGivenUsersBlogPosts("PussyCat");
        Assert.assertTrue(compareLists(expectedBlogPosts,actualBlogPosts));
    }
        private boolean compareLists(List< BlogPosts > expected, List<BlogPosts> actual) {
            if (!(actual != null && expected.size() == actual.size()))
                return false;
            for (int i = 0; i < expected.size(); i++) {
                if (!expected.get(i).getBlogPostName().equals(actual.get(i).getBlogPostName()))
                    return false;
            }
            return true;
        }
    }

