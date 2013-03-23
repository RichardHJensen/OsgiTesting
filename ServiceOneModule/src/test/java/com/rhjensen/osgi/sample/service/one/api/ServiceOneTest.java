package com.rhjensen.osgi.sample.service.one.api;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ServiceOneTest {
    @Test
    public void shouldGiveHelloWorld() {
        ServiceOne serviceOne = new ServiceOne();
        assertThat(serviceOne.greeting(), is("Hello World!"));

    }
}
