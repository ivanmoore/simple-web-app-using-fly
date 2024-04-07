package com.oocode;

public class QueryDecoder {
    public static String decode(String queryEncoded) {
        return queryEncoded
                .replace("+", " ")
                .replace("%3F", "?");
    }
}
