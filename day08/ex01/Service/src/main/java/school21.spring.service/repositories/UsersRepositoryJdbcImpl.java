package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private final DataSource dataSource;

    private final String FIND_ALL = "select * from users";

    private final String FIND_BY_ID = "select * from users where identifier = ?";

    private final String UPDATE = "update users set email = ? where identifier = ?";

    private final String SAVE = "insert into users values (?, ?)";

    private final String DELETE = "delete from users where identifier = ?";

    private final String FIND_BY_EMAIL = "select * from users where email = ?";

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next())
            {
                long id = resultSet.getLong("identifier");
                String email = resultSet.getString("email");
                User user = new User();
                user.setIdentifier(id);
                user.setEmail(email);
                userList.add(user);
            }
            connection.close();
            return (userList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (userList);
    }

    @Override
    public User findById(Long id) {

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
               String email = resultSet.getString("email");
               User user = new User();
               user.setIdentifier(id);
               user.setEmail(email);
                connection.close();
               return (user);
            }

        } catch (SQLException e) {
            try {
                throw new IllegalAccessException(e.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        }
        return (null);
    }

    @Override
    public void save(User user) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SAVE);
            statement.setLong(1, user.getIdentifier());
            statement.setString(2, user.getEmail());
            if (statement.executeUpdate() == 0) {
                throw new IllegalAccessException("Can't save the data");
            }
            connection.close();
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setLong(2, user.getIdentifier());
            statement.setString(1, user.getEmail());
            if (statement.executeUpdate() == 0) {
                throw new IllegalAccessException("Can't update the data");
            }
            connection.close();
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, id);
            if (statement.executeUpdate() == 0) {
                throw new IllegalAccessException("Can't delete the data");
            }
            connection.close();
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                long id = resultSet.getLong("id");
                User user = new User();
                user.setIdentifier(id);
                user.setEmail(email);
                connection.close();
                return  (Optional.of(user));
            }

        } catch (SQLException e) {
            try {
                throw new IllegalAccessException(e.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        }
        return (Optional.empty());
    }
}