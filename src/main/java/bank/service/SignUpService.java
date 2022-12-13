package bank.service;

import bank.dto.SignUpRequest;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.sql.Connection;

public class SignUpService {

    public boolean signUp(SignUpRequest request) {
        ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        try {

            File file = new File("ek/Accounts.json");
            if (!file.exists()) {
                file.createNewFile();
            }

            // eğer dosyada veri varsa, alıp, yeni veriyi ekleyip, tekrar yazıyoruz.

            mapper.writeValue(file, request);


            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static void main(String[] args) {
        SignUpService signUpService = new SignUpService();
        SignUpRequest request = SignUpRequest.builder()
                .surname("surndfgdfgdfgame")
                .name("namehgkgkuy")
                .password("patronymic")
                .phoneNumber("phoneNumber")
                .build();

        signUpService.signUp(request);

    }
}
