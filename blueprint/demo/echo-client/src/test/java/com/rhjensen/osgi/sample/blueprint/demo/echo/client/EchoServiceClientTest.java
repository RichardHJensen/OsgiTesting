package com.rhjensen.osgi.sample.blueprint.demo.echo.client;

import com.rhjensen.osgi.sample.blueprint.demo.echo.api.EchoService;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class EchoServiceClientTest {
    @Test
    public void shouldSendMessageWhenInitialized() {
        EchoService mockEchoService = mock(EchoService.class);
        EchoServiceClient client = new EchoServiceClient();
        client.setService(mockEchoService);
        client.initialize();
        verify(mockEchoService, times(1)).echoMessage(anyString());
    }
}
