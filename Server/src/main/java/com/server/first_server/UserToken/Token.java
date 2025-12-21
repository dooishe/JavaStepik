package com.server.first_server.UserToken;

import java.util.HashMap;
import java.util.Map;

public class Token {
    public static final Map<String, Integer> TOKENS = new HashMap<>();

    public static int checkToken(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Unauthorized");
        }
        String token = authHeader.substring(7);

        if (!TOKENS.containsKey(token)) {
            throw new RuntimeException("Invalid token");
        }

        int user = TOKENS.get(token);

        return user;
    }
}
