package com.example.auth_service.service;



import com.fasterxml.jackson.core.JsonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class GoogleTokenValidator {

    @Value("${spring.secruity.oauth2.client.registration.google.client-id}")
    private String googleClientId;

    public GoogleIdToken.Payload validateToken(String idToken) throws Exception {
        // Use GsonFactory instead of JacksonFactory
        System.out.println("hello in validate");
        GsonFactory jsonFactory = GsonFactory.getDefaultInstance();

        System.out.println("going to google verifier");

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                new NetHttpTransport(),
                jsonFactory
        ).setAudience(Collections.singletonList(googleClientId)).build();

        System.out.println("going to verify(idToken) ");

        GoogleIdToken googleIdToken = verifier.verify(idToken);
        System.out.println("google id token is " + googleIdToken);
        if (googleIdToken != null) {
            System.out.println("payload is "+googleIdToken.getPayload());
            return googleIdToken.getPayload();
        } else {
            throw new RuntimeException("Invalid ID token");
        }
    }
}