package cat.tecnocampus.messaging.persistence;

import domain.Message;
import domain.MyUser;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.simpleflatmapper.jdbc.spring.ResultSetExtractorImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {
    private JdbcTemplate jdbcTemplate;
    private ResultSetExtractorImpl<MyUser> userExtractor;
    private ResultSetExtractorImpl<MyUser> sigleUserExtractor;


    private final String QUERY_USERS = "select userName, name, second_name from myuser";

    private final String QUERY_USER = "select u.username, u.name, u.second_name, m.sender as receivedMessages_sender_username, " +
            "m.date as receivedMessages_date, m.title as receivedMessages_title, m.content as receivedMessages_content " +
            "from myuser u " +
            "left join message m " +
            "on m.receiver = u.username " +
            "where u.username = ?";

    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        userExtractor = JdbcTemplateMapperFactory
                .newInstance()
                .addKeys("userName")
                .newResultSetExtractor(MyUser.class);

    }

    public List<MyUser> getUsersNoMessages() {
        return jdbcTemplate.query(QUERY_USERS, userExtractor);
    }

    // TODO 2 JDBD Template
    //  Get the user with all her received messages. You can use the QUERY_USER and the example above or any other technique you want
    public MyUser getUser(String userName) {
        return null;
    }
}