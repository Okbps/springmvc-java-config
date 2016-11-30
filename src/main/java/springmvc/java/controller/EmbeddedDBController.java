package springmvc.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by Aspire on 22.11.2016.
 */
@Controller
public class EmbeddedDBController {
    private static final Logger LOGGER =LoggerFactory.getLogger(EmbeddedDBController.class);

    @Autowired
    @Qualifier("embedded")
    private DataSource dataSourceEmbedded;
    @Autowired
    @Qualifier("mySQL")
    private DataSource dataSourceMySQL;

    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/displayUsersMySQL", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public @ResponseBody List displayUsers(){
        jdbcTemplate = new JdbcTemplate(dataSourceMySQL);

        List<Map<String, Object>>users = jdbcTemplate.queryForList("SELECT * FROM USER");

//        for (Map<String, Object>user: users){
//            LOGGER.debug("username: "+user.get("username"));
//        }

        return users;
    }
}
