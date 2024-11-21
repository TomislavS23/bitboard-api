package dev.bitboard.api.controller;
import dev.bitboard.api.model.User;
import dev.bitboard.api.repository.UserRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public UserController() {
    }

    @GetMapping("/read")
    public ResponseEntity<List<User>> getUsers() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userRepository.findUsers());
        } catch (HibernateException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
