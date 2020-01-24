package cat.tecnocampus.messaging.domainService;

import cat.tecnocampus.messaging.persistence.MessageDAO;
import cat.tecnocampus.messaging.persistence.UserDAO;
import domain.Exception.MessageEqualSenderAndReceiver;
import domain.Message;
import domain.MyUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomainService {
    private UserDAO userPersistence;
    private MessageDAO messageDAO;

    public DomainService(UserDAO userPersistence, MessageDAO messageDAO) {
        this.userPersistence = userPersistence;
        this.messageDAO = messageDAO;
    }

    public List<MyUser> getUsers() {
        return userPersistence.getUsersNoMessages();
    }

    public List<MyUser> getUsersMyselfExcluded(String myselfUsername) {
        return getUsers().stream().filter(m -> !m.getUsername().equals(myselfUsername)).collect(Collectors.toList());
    }

    public MyUser getUser(String userName) {
        return userPersistence.getUser(userName);
    }

    public Message sendMessage(Message message) {
        if (message.sameSenderReceiver()) {
            throw new MessageEqualSenderAndReceiver("Sender and receiver are the same: " + message.getReceiver().getUsername());
        }
        return messageDAO.saveMessage(message);
    }
}
