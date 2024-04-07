package com.oocode;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SimpleHttpClient {
    public String readUrl(String url) throws IOException {
        try (Scanner scanner = new Scanner(new URI(url).toURL().openStream(), UTF_8)) {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        } catch (URISyntaxException e) {
            throw new IOException(e);
        }
    }
}
