package dev.bitboard.api.repository;

import dev.bitboard.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryExtension {

    @Query("FROM User")
    List<User> findUsers();
}
