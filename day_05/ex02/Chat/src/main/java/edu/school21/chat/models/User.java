package edu.school21.chat.models;

import java.util.LinkedList;
import java.util.Objects;

public class User {

    private long id;
    private String login;
    private String password;
    private LinkedList<ChatRoom> createdChatRooms;
    private LinkedList<ChatRoom> activeChatRooms;

    public long getId() {

        return id;
    }

    public String getLogin() {

        return (login);
    }

    public String getPassword() {

        return (password);
    }

    public LinkedList<ChatRoom> getCreatedChatRooms() {

        return (createdChatRooms);
    }

    public LinkedList<ChatRoom> getActiveChatRooms() {

        return (activeChatRooms);
    }

    public void setId(long id) {

        this.id = id;
    }

    public void setLogin(String login) {

        this.login = login;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public void setCreatedChatRooms(LinkedList<ChatRoom> createdChatRooms) {

        this.createdChatRooms = createdChatRooms;
    }

    public void setActiveChatRooms(LinkedList<ChatRoom> activeChatRooms) {

        this.activeChatRooms = activeChatRooms;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return (true);
        }

        if (object == null || getClass() != object.getClass()) {
            return (false);
        }

        User user = (User) object;
        return (this.id == user.id && this.login.equals(user.login) && this.password.equals(user.password)
                && this.createdChatRooms.equals(user.createdChatRooms)
                && this.activeChatRooms.equals(user.activeChatRooms));
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password, createdChatRooms, activeChatRooms);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdChatRooms=" + createdChatRooms +
                ", activeChatRooms=" + activeChatRooms +
                '}';
    }
}
