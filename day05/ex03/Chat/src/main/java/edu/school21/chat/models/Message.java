package edu.school21.chat.models;

import java.sql.Timestamp;
import java.util.Objects;

public class Message {

    private long id;
    private User user;
    private ChatRoom chatRoom;
    private String text;
    private Timestamp date;

    public long getId() {

        return id;
    }

    public User getUser() {

        return user;
    }

    public ChatRoom getChatRoom() {

        return chatRoom;
    }

    public String getText() {

        return text;
    }

    public Timestamp getDate() {

        return date;
    }

    public void setId(long id) {

        this.id = id;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public void setChatRoom(ChatRoom chatRoom) {

        this.chatRoom = chatRoom;
    }

    public void setText(String text) {

        this.text = text;
    }

    public void setDate(Timestamp date) {
        if (date != null) {
            this.date = date;
        } else {
            this.date = new Timestamp(System.currentTimeMillis());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return (true);
        }
        if (o == null || getClass() != o.getClass()) {
            return (false);
        }
        Message message = (Message) o;
        return (user == message.user && chatRoom == message.chatRoom
                && text.equals(message.text) && date.equals(message.date));
    }

    @Override
    public int hashCode() {
        return (Objects.hash(id, user, chatRoom, text, date));
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + this.id +
                " user=" + user.toString() +
                ", chartRoom=" + chatRoom.toString() +
                ", text='" + text + '\'' +
                ", date/time=" + date +
                '}';
    }
}
