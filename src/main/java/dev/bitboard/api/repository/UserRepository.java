package dev.bitboard.api.repository;

import dev.bitboard.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User")
    List<User> findUsers();

    @Query("FROM User u WHERE u.id = :id")
    User findUserById(@Param("id") Long id);

    @Query("FROM User u WHERE u.username LIKE %:username%")
    List<User> findByUsername(@Param("username") String username);

    @Modifying
    @Transactional
    @Query("DELETE User WHERE id = :id")
    void deleteUserById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE User SET username = :username, email = :email WHERE id = :id")
    void updateUser(@Param("id") Integer id ,@Param("username") String username, @Param("email") String email);

    @Modifying
    @Transactional
    @Query("INSERT INTO User(username, email, hashedPassword, salt) VALUES (:username, :email, :hashedPassword, :salt)")
    void insertUser(
            @Param("username") String username,
            @Param("email") String email,
            @Param("hashedPassword") String hashedPassword,
            @Param("salt") String salt
    );
}
