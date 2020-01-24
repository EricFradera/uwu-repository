package domain.Exception;

public class MessageEqualSenderAndReceiver extends RuntimeException {
    public MessageEqualSenderAndReceiver(String message) {
        super(message);
    }
}
