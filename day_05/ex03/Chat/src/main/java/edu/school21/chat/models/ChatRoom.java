package edu.school21.chat.models;

import java.util.LinkedList;
import java.util.Objects;

public class ChatRoom {

    private long id;
    private String name;
    private User creator;
    private LinkedList<Message> messagesList;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getCreator() {
        return creator;
    }

    public LinkedList<Message> getMessagesList() {

        return messagesList;
    }

    public void setId(long id) {

        this.id = id;
    }

    public void setCreator(User creator) {

        this.creator = creator;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setMessagesList(LinkedList<Message> messagesList) {

        this.messagesList = messagesList;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return (true);
        }
        if (object == null || getClass() != object.getClass()) {
            return (false);
        }
        ChatRoom chatRoom = (ChatRoom)object;
        return (id == chatRoom.id && name.equals(chatRoom.name)
                && creator.equals(chatRoom.creator)
                && Objects.equals(messagesList, chatRoom.messagesList));
    }

    @Override
    public int hashCode() {
        return
                Objects.hash(id, name, creator, messagesList);
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creator=" + creator +
                ", messagesList=" + messagesList +
                '}';
    }
}
