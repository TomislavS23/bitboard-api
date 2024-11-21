package dev.bitboard.api.controller;

import dev.bitboard.api.model.User;
import dev.bitboard.api.repository.UserRepository;
import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-management")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findUsers() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userRepository.findUsers());
        } catch (HibernateException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        try {
            var entity = userRepository.findUserById(id);

            if (entity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.status(HttpStatus.OK).body(entity);
        } catch (HibernateException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/by-username/{username}")
    public ResponseEntity<List<User>> findUserByUsername(@PathVariable String username) {
        try {
            var entity = userRepository.findByUsername(username);

            if (entity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.status(HttpStatus.OK).body(entity);
        } catch (HibernateException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            userRepository.deleteUserById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (HibernateException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody User user) {
        try {
            userRepository.updateUser(id, user.getUsername(), user.getEmail());
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (HibernateException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<Void> insertUser(@RequestBody User user) {
        try {
            userRepository.insertUser(
                    user.getUsername(),
                    user.getEmail(),
                    user.getHashedPassword(),
                    user.getSalt()
            );

            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (HibernateException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
