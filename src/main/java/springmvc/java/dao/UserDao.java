package springmvc.java.dao;

import org.springframework.data.repository.CrudRepository;
import springmvc.java.domain.User;

/**
 * Created by Aspire on 24.11.2016.
 */
public interface UserDao extends CrudRepository<User, Long>{

    User findUserByUsername(String username);
}
