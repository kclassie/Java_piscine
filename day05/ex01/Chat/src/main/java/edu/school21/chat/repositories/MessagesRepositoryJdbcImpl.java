package edu.school21.chat.repositories;

import edu.school21.chat.models.ChatRoom;
import school21.chat.repositories.MessagesRepository;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final HikariDataSource dataSource;

    public MessagesRepositoryJdbcImpl(HikariDataSource dataSource) {

        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) {

        Statement statement;
        ResultSet result;
        User user = new User();
        ChatRoom chatRoom = new ChatRoom();
        Message message = new Message();

        try {
            statement = dataSource.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sql = "select u.id as user_id, u.login, u.password, cr.id as room_id, cr.name, m.text, m.date " +
                "from messages m  " +
                "join chat_rooms cr on cr.id = m.chat_room " +
                "join users u on u.id = m.author " +
                "where m.id = " + id;

        try {
            result = statement.executeQuery(sql);

            if (result.next()) {
                message.setId(id);
                user.setId(result.getLong("user_id"));
                user.setLogin(result.getString("login"));
                user.setPassword(result.getString("password"));
                chatRoom.setId(result.getLong("room_id"));
                chatRoom.setName(result.getString("name"));
                message.setText(result.getString("text"));
                message.setDate(Timestamp.valueOf(result.getString("date")));
                message.setChatRoom(chatRoom);
                message.setUser(user);
                return (Optional.of(message));
            }
            return (Optional.empty());
        } catch (SQLException e) {
            dataSource.close();
            throw new RuntimeException(e);
        }
    }
}
