package springmvc.java.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import springmvc.java.config.WebConfig;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.UserService;

import static org.junit.Assert.*;

/**
 * Created by Aspire on 27.11.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class}, loader = AnnotationConfigWebContextLoader.class)
public class BlogPostServiceTest {

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private UserService userService;

    @Test
    public void testBlogPostService(){
        User user = userService.findUserWithBlogPostsByUsername("user");

        assertNotNull(user);

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("title 1");
        blogPost.setContent("test content 1");
        blogPost.setUser(user);
        blogPostService.savePost(blogPost);

        blogPostService.deleteBlogPost(blogPost);

        assertTrue(blogPostService.listAllBlogPostsByUserAndTitleLike(user, "title 1").size()==0);

        BlogPost blogPostDraft = new BlogPost();
        blogPostDraft.setTitle("title 2");
        blogPostDraft.setDraft(true);
        blogPostDraft.setContent("user");
        blogPostDraft.setUser(user);

        blogPostService.saveAsDraft(blogPostDraft);

        assertTrue(blogPostService.listAllBlogPostsByUserAndDraftStatus(user, true).size()>0);

        blogPostService.deleteBlogPost(blogPostDraft);
    }
}
