package springmvc.java.dao;

import org.springframework.data.repository.CrudRepository;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;

import java.util.List;

/**
 * Created by Aspire on 23.11.2016.
 */
public interface BlogPostDAO extends CrudRepository<BlogPost, Long>{

    List<BlogPost>findAllBlogPostsByUserAndTitleContaining(User user, String title);
    List<BlogPost>findAllBlogPostsByUserAndDraft(User user, boolean draft);

}
