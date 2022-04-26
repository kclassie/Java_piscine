package school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Message;
import java.util.Optional;

public interface MessagesRepository {

    Optional<Message> findById(Long id);
    boolean save(Message message) throws NotSavedSubEntityException;
    boolean update(Message message) throws NotSavedSubEntityException;
}

