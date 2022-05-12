package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
    private final JdbcTemplate template;

    private final String FIND_ALL = "select * from users";

    private final String FIND_BY_ID = "select * from users where identifier = ?";

    private final String UPDATE = "update users set email = ? where identifier = ?";

    private final String SAVE = "insert into users (email) values (?)";

    private final String DELETE = "delete from users where identifier = ?";

    private final String FIND_BY_EMAIL = "select * from users where email = ?";

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String sqlQuery = "select * from users where email = " + email;
        List<User> userList = template.queryForList(sqlQuery, User.class);
        if (userList.isEmpty()) {
            return (Optional.empty());
        } else {
            return (Optional.of(userList.get(0)));
        }
    }

    @Override
    public User findById(Long id) {
        List<User> userList = template.query(FIND_BY_ID, new UserMapper());
        if (userList.isEmpty()) {
            return (null);
        } else {
            return (userList.get(0));
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = template.query(FIND_ALL, new UserMapper());
        return (users);
    }

    @Override
    public void save(User entity) {
        template.update(SAVE, entity.getIdentifier(), entity.getEmail());
    }

    @Override
    public void update(User entity) {
        template.update(UPDATE, entity.getIdentifier(), entity.getEmail());

    }

    @Override
    public void delete(Long id) {
        template.update(DELETE, id);
    }
}

class UserMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setIdentifier(rs.getLong("identifier"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}