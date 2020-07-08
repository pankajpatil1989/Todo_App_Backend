package com.pankaj.restfulwebservices;

import com.pankaj.restfulwebservices.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BcryptEncoderTest {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        for(int i=1; i<=10; i++) {
            String encodedString = encoder.encode("pankaj");
            System.out.println(encodedString);
        }
        BCryptPasswordEncoder encoder1 = new BCryptPasswordEncoder();
        String secret1 = "{bcrypt}" + encoder1.encode("pankaj");
        String secret2 = "{bcrypt}" + encoder1.encode("user");
        System.out.println(secret1);
        System.out.println(secret2);
        // TODO Auto-generated method stub

    }
}
