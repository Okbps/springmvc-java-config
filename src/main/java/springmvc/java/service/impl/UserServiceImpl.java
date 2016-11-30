package springmvc.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc.java.dao.UserDao;
import springmvc.java.domain.User;
import springmvc.java.service.UserService;

/**
 * Created by Aspire on 24.11.2016.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDAO;

    public User findUserById(long id) {
        return userDAO.findOne(id);
    }

    public User findUserWithBlogPostsByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }
}
