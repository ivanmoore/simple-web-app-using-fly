package com.oocode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class AnsweringServerTest {
    private AnsweringServer server;

    @Test
    public void canAnswerMyName() throws Exception {
        var contents = new SimpleHttpClient().readUrl("http://127.0.0.1:9123?q=What+is+your+name%3F");

        assertThat(contents, equalTo("Someone"));
    }

    @Test
    public void showsHomePageIfMissingQueryString() throws Exception {
        var contents = new SimpleHttpClient().readUrl("http://127.0.0.1:9123");

        assertThat(contents, containsString("<html>"));
    }

    @BeforeEach
    public void startLocalServer() {
        server = new AnsweringServer(9123);
        server.start();
    }

    @AfterEach
    public void stopLocalServer() {
        server.stop();
    }
}
