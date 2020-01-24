package domain;

import java.util.ArrayList;
import java.util.List;

public class MyUser {
    private String username;
    private String name;
    private String secondName;
    private List<Message> sentMessages;
    private List<Message> receivedMessages;

    public MyUser() {
        sentMessages = new ArrayList<>();
        receivedMessages = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> messages) {
        this.receivedMessages = messages;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "userName='" + username + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                //", receivedMessages='" + receivedMessages + '\'' +
                '}';
    }
}
