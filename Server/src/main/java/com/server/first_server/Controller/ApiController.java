package com.server.first_server.Controller;

import com.server.first_server.DTO.GameRequest;
import com.server.first_server.UserToken.Token;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@RestController
public class ApiController {

    @GetMapping("/login/{id}")
    public Map<String, String> login(@PathVariable int id) {
        String VALID_TOKEN = UUID.randomUUID().toString();
        Token.TOKENS.put(VALID_TOKEN, id);
        return Map.of("token", VALID_TOKEN);
    }

    @GetMapping("/tokens")
    public Map<String, Integer> tokens() {
        return Token.TOKENS;
    }

    @GetMapping("/image")
    public ResponseEntity<Resource> image(
            @RequestHeader("Authorization") String authHeader
    ) throws IOException {
        Token.checkToken(authHeader);
        ClassPathResource img = new ClassPathResource("static/image.jpg");


        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE)
                .contentLength(img.contentLength())
                .body(img);
    }

    @PostMapping("/game")
    public Map<String, String> game(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody GameRequest request
    ) {
        Token.checkToken(authHeader);
        String result;
        if (request.score1() > request.score2()) result = "win";
        else if (request.score1() < request.score2()) result = "loss";
        else result = "draw";


        return Map.of("result", result);
    }

    @DeleteMapping("/delete")
    public Map<String, String> delete(
            @RequestHeader("Authorization") String authHeader,
            @RequestParam String id
    ) {
        Token.checkToken(authHeader);
        return Map.of(
                "status", "deleted",
                "id", id
        );
    }
}

