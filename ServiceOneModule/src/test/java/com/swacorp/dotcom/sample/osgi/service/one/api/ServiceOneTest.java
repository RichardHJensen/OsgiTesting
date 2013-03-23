package com.swacorp.dotcom.sample.osgi.service.one.api;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created with IntelliJ IDEA.
 * User: rjensen
 * Date: 3/23/13
 * Time: 1:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ServiceOneTest {
    @Test
    public void shouldGiveHelloWorld() {
        ServiceOne serviceOne = new ServiceOne();
        assertThat(serviceOne.greeting(), is("Hello World!"));

    }
}
