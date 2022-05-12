package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import java.util.Optional;
import school21.chat.repositories.MessagesRepository;

public class Program {

    public static void main(String[] args){

        HikariDataSource dataSource = new HikariDataSource();
        dataSource .setJdbcUrl("jdbc:postgresql://localhost:5432/chat_app_db");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(dataSource);

        Optional<Message> messageOptional = repository.findById((long)3);

        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setText("Bye");
            message.setDate(null);
            repository.update(message);
        }
        dataSource.close();
    }
}
