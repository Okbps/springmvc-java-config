package springmvc.java.service;

import springmvc.java.domain.User;

/**
 * Created by Aspire on 24.11.2016.
 */
public interface UserService {
    User findUserById(long id);
    User findUserWithBlogPostsByUsername(String username);
}
