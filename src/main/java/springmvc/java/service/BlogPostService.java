package springmvc.java.service;

import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;

import java.util.List;

public interface BlogPostService {
	
	void savePost(BlogPost blogPost);
	void saveAsDraft(BlogPost blogPost);
	void deleteBlogPost(BlogPost blogPost);
	List<BlogPost> listAllBlogPostsByUserAndDraftStatus(User user, boolean draft);
	List<BlogPost> listAllBlogPostsByUserAndTitleLike(User user, String title);
	BlogPost findBlogPostById(long id);
}
