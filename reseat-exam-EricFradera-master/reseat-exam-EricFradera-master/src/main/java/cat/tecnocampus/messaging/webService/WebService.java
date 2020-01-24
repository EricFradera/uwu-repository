package cat.tecnocampus.messaging.webService;

import cat.tecnocampus.messaging.domainService.DomainService;
import domain.Exception.MessageEqualSenderAndReceiver;
import domain.Message;
import domain.MyUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class WebService {
    private DomainService domainService;
    private static final Logger logger = LoggerFactory.getLogger(WebService.class);


    public WebService(DomainService domainService) {
        this.domainService = domainService;
    }

    @GetMapping("users")
    public String users(Model model) {
        model.addAttribute("users", domainService.getUsers());
        return "userList";
    }

    @GetMapping("my/messages")
    public String messages(Model model, Principal principal) {
        model.addAttribute("user", domainService.getUser((principal.getName())));
        return "myMessages";
    }

    // TODO 3: WEB. Implement the functionality of sending a new message.
    //  * The sender must be the logged in user
    //  * The receiver must be choosen from a list with all the users

    // TODO 3.1: Send message. Get mapping
    //  You need a get mapping that returns a form.
    //      See that the form must show a select with all the users (potential receivers)
    //      Make sure that the sender is set with the logged in user
    //      you may need parameters
    @GetMapping("sendMessage")
    public String sendMessage() {
        return "sendMessage";
    }

    // TODO 3.3: Send message. Post mapping
    //  You need a post mapping that takes the message from the form and calls the domainService to store it
    //  Once it's done the user should see the list of users
    //  You may need parameters
    @PostMapping("sendMessage")
    public String sendMessagePost() {
        return null;
    }

    //TODO 7: Error validation.
    //  In the postMapping when sending a message make sure that the title and content of the message is validated and
    //  the user is asked again to fill in the message

    // TODO 4: error exception
    //  A user cannot send a message to herself (same sender and receiver). When it happens a  MessageEqualSenderAndReceiver is
    //  thrown. When this happens the page "error.html" should be returned
}
