package com.oocode;

import io.fusionauth.http.server.HTTPHandler;
import io.fusionauth.http.server.HTTPListenerConfiguration;
import io.fusionauth.http.server.HTTPServer;

import java.io.Writer;

public class AnsweringServer {
    private final HTTPServer server;

    public static void main(String[] args) {
        int port = 8123;
        System.out.println("Starting server on port:" + port);
        new AnsweringServer(port).start();
    }

    public AnsweringServer(int port) {
        HTTPHandler handler = (req, res) -> {
            try (Writer writer = res.getWriter()) {
                writer.write(responseForQuery(req.getParameter("q")));
            }
        };
        server = new HTTPServer().withHandler(handler).withListener(new HTTPListenerConfiguration(port));
    }

    private static String responseForQuery(String queryEncoded) {
        if (queryEncoded == null) {
            return HomePage.HTML;
        } else {
            String value = QueryDecoder.decode(queryEncoded);
            System.out.println("value = " + value);
            return new Answerer().answerFor(value);
        }
    }

    public void start() {
        server.start();
    }

    public void stop() {
        server.close();
    }
}

