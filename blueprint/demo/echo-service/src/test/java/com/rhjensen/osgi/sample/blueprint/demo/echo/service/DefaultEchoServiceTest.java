package com.rhjensen.osgi.sample.blueprint.demo.echo.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

/**
 * User: rjensen
 * Date: 3/28/13
 * Time: 12:29 PM
 */
public class DefaultEchoServiceTest {

    private DefaultEchoService service;
    private PrintStream mockOutput;

    @Before
    public void setUp() throws Exception {
        service = new DefaultEchoService();
        mockOutput = mock(PrintStream.class);
        service.setOutputStream(mockOutput);
    }

    @Test
    public void shouldReverseGivenText() {
        service.echoMessage("0123456789");
        ArgumentCaptor<String> stringArgCaptor = ArgumentCaptor.forClass(String.class);
        verify(mockOutput, times(1)).println(stringArgCaptor.capture());
        assertThat(stringArgCaptor.getValue(), is("9876543210"));
    }

    @Test
    public void shouldWriteAMessageWhenInitializing() {
        service.initialize();
        verify(mockOutput, times(1)).println(anyString());
    }
}
