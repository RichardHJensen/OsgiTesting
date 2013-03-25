package com.rhjensen.osgi.sample.service.one;

import com.rhjensen.osgi.sample.service.one.api.ServiceOne;
import com.rhjensen.osgi.sample.service.one.impl.ServiceOneImpl;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ServiceOneTest {
    @Test
    public void shouldGiveHelloWorld() {
        ServiceOne serviceOne = new ServiceOneImpl();
        assertThat(serviceOne.greeting(), is("Hello World!"));
    }
}
