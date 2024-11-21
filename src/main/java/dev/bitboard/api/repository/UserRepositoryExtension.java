package dev.bitboard.api.repository;

import dev.bitboard.api.model.User;

import java.util.List;

public interface UserRepositoryExtension {
    List<User> getUsers();

    User getUserById(Integer id);

    User getUserByUsername(String username);

    void insertUser(User user);
}
