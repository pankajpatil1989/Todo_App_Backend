package com.pankaj.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
