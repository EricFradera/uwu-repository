package domain;

import domain.Exception.MessageEqualSenderAndReceiver;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class Message {
    private long id;
    private MyUser sender;
    private MyUser receiver;
    private LocalDateTime dateTime;

    // TODO 6: Validation. Annotate this class so that
    //      * The title is not null, its length is between 5 and 255 characters, and all characters must be alphanumeric
    //      * Make sure that the validation is done in the web controller (TODO7)

    private String title;

    private String content;

    public Message() {
        dateTime = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MyUser getSender() {
        return sender;
    }

    public void setSender(MyUser sender) {
        this.sender = sender;
    }

    public MyUser getReceiver() {
        return receiver;
    }

    public void setReceiver(MyUser receiver) {
        this.receiver = receiver;
    }

    public boolean sameSenderReceiver() {
        return receiver.getUsername().equals(this.sender.getUsername());
    }

    public LocalDateTime getDate() {
        return dateTime;
    }

    public void setDate(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + sender.getUsername() +
                ", receiver=" + receiver.getUsername() +
                ", dateTime=" + dateTime +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
