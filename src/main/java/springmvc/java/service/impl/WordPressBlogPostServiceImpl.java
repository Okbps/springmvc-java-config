package springmvc.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;

import java.util.List;

/**
 * Created by Aspire on 20.11.2016.
 */
public class WordPressBlogPostServiceImpl implements BlogPostService{
    private static final Logger LOGGER = LoggerFactory.getLogger(WordPressBlogPostServiceImpl.class);

    public void savePost(BlogPost blogPost) {
        LOGGER.debug("WordPressBlogPostServiceImpl savePost is called");
    }

    public void saveAsDraft(BlogPost blogPost) {

    }

    public void deleteBlogPost(BlogPost blogPost) {

    }

    public List<BlogPost> listAllBlogPostsByUserAndDraftStatus(User user, boolean draft) {
        return null;
    }

    public List<BlogPost> listAllBlogPostsByUserAndTitleLike(User user, String title) {
        return null;
    }

    public BlogPost findBlogPostById(long id) {
        return null;
    }
}
