package springmvc.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import springmvc.java.dao.BlogPostDAO;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.MyDataSource;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.EMailService;

import java.util.Date;
import java.util.List;

public class BlogPostServiceImpl implements BlogPostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);

    @Autowired
    private BlogPostDAO blogPostDAO;

    @Autowired
    private EMailService eMailService;

    public void savePost(BlogPost blogPost) {
        LOGGER.debug("BlogPostServiceImpl: savePost is called");
        blogPost.setPublishDate(new Date());
//        char[]arr = {'\uD83C', '\uDF1F'};
//        blogPost.setContent(String.valueOf(arr));
        blogPostDAO.save(blogPost);
    }

    public void saveAsDraft(BlogPost blogPost) {
        blogPost.setDraft(true);
        blogPostDAO.save(blogPost);
    }

    public void deleteBlogPost(BlogPost blogPost) {
        blogPostDAO.delete(blogPost);
    }

    public List<BlogPost> listAllBlogPostsByUserAndDraftStatus(User user, boolean draft) {
        return blogPostDAO.findAllBlogPostsByUserAndDraft(user, draft);
    }

    public List<BlogPost> listAllBlogPostsByUserAndTitleLike(User user, String title) {
        return blogPostDAO.findAllBlogPostsByUserAndTitleContaining(user, title);
    }

    public BlogPost findBlogPostById(long id) {
        return blogPostDAO.findOne(id);
    }

}
