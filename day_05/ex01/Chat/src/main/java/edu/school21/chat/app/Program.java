package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import java.util.Optional;
import java.util.Scanner;
import school21.chat.repositories.MessagesRepository;

public class Program {

    public static void main(String[] args) {

        HikariDataSource dataSource = new HikariDataSource();
        Message message;
        Optional<Message> optionalMessage;
        dataSource .setJdbcUrl("jdbc:postgresql://localhost:5432/chat_app_db");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(dataSource );

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a message ID\n -> ");
        long message_id = scanner.nextLong();
        optionalMessage = repository.findById(message_id);
        if (optionalMessage.isPresent()) {
            message = optionalMessage.get();
            System.out.println(message.toString());
        } else {
            System.out.println("Chat_app_database: Index not found");
        }
        dataSource.close();
    }
}
