package com.oocode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class QueryDecoderTest {
    @Test
    public void decodesSpaces() {
        assertThat(QueryDecoder.decode("What+is+your+name"), equalTo("What is your name"));
    }

    @Test
    public void decodesQuestionMarks() {
        assertThat(QueryDecoder.decode("What+is+your+name%3F"), equalTo("What is your name?"));
    }
}