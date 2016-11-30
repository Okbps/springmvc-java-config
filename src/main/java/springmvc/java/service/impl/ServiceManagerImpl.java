package springmvc.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import springmvc.java.domain.BlogPost;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.ServiceManager;

/**
 * Created by Aspire on 20.11.2016.
 */
public class ServiceManagerImpl implements ServiceManager{
    @Autowired
    @Qualifier("MediumBlogPostService")
    private BlogPostService blogPostService;

    public void sendBlogPost(BlogPost blogPost) {
        blogPostService.savePost(blogPost);
    }
}
