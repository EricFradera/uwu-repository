package cat.tecnocampus.messaging.persistence;

import domain.Message;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;

@Component
public class MessageDAO {
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_MESSAGE = "insert into message (title, content, date, sender, receiver) values(?, ?, ?, ?, ?)";

    public MessageDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Message saveMessage(Message message) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        this.jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_MESSAGE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, message.getTitle());
            preparedStatement.setString(2, message.getContent());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(message.getDate()));
            preparedStatement.setString(4, message.getSender().getUsername());
            preparedStatement.setString(5, message.getReceiver().getUsername());
            return preparedStatement;
        }, generatedKeyHolder);

        long idOfNewMessage = generatedKeyHolder.getKey().longValue();
        message.setId(idOfNewMessage);
        return message;
    }
}
