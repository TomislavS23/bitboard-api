package dev.bitboard.api.service;

import dev.bitboard.api.model.User;
import dev.bitboard.api.repository.UserRepositoryExtension;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryExtension {

    private static final String SELECT_USER = "FROM User";
    private static final String SELECT_USER_BY_ID = "FROM User U WHERE U.id = :id";
    private static final String SELECT_USER_BY_USERNAME = "FROM User U WHERE U.username = :username";
    private static final String INSERT_USER =
            "INSERT User (username, email, hashedPassword, salt) " +
                    "VALUES (:username, :email, :hashedPassword, :salt)";

    private final SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.openSession();
        return session.createQuery(SELECT_USER, User.class).getResultList();
    }

    @Override
    public User getUserById(Integer id) {
        Session session = sessionFactory.openSession();
        return session
                .createQuery(SELECT_USER_BY_ID, User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public User getUserByUsername(String username) {
        Session session = sessionFactory.openSession();
        return session
                .createQuery(SELECT_USER_BY_USERNAME, User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public void insertUser(User user) {
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery(INSERT_USER)
                    .setParameter("username", user.getUsername())
                    .setParameter("email", user.getEmail())
                    .setParameter("hashedPassword", user.getHashedPassword())
                    .setParameter("salt", user.getSalt())
                    .executeUpdate();
        });
    }
}
