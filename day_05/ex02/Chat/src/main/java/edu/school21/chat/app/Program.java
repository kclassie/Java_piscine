package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.util.LinkedList;
import school21.chat.repositories.MessagesRepository;

public class Program {

    public static void main(String[] args) {

        HikariDataSource dataSource = new HikariDataSource();
        dataSource .setJdbcUrl("jdbc:postgresql://localhost:5432/chat_app_db");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(dataSource);

        User creator = new User();
        creator.setId(2);
        creator.setCreatedChatRooms(new LinkedList<ChatRoom>());
        creator.setActiveChatRooms(new LinkedList<ChatRoom>());
        ChatRoom room = new ChatRoom();
        room.setId(1);
        room.setMessagesList(new LinkedList<Message>());
        Message message = new Message();
        message.setUser(creator);
        message.setChatRoom(room);
        message.setText("F*cking Java =))");
        try {
            repository.save(message);
        } catch (Exception e) {
            throw new NegativeArraySizeException();
        }
        System.out.println(message.getId());
        dataSource.close();
    }
}
