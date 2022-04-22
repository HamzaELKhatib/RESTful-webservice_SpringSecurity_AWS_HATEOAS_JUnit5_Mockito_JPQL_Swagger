package com.rest.security;

public class SecurityConstants {
    public static final String TOKEN_SECRET = "jh5gt6dc5g41b9ju3s47";
    public static final long EXPIRATION_TIME = 864000000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";
}
