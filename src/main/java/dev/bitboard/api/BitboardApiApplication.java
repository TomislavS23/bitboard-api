package dev.bitboard.api;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BitboardApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitboardApiApplication.class, args);
    }

}
