package com.gradle_hotel.gradel_hotel.constants;

public class JWTConstants {
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    // 1 month expiration time in milliseconds (1000 ms * 60 sec * 60 min * 24 hours * 30 days)
    public static final long EXPIRE_TIME = 1000L * 60 * 60 * 24 * 30;
    public static final String SECRET_KEY = "843567893696976453275974432697R634976R738467TR678T34865R6834R8763T478378637664538745673865783678548735687R3";
}
