package com.rhjensen.osgi.sample.blueprint.demo.echo.client;

import com.rhjensen.osgi.sample.blueprint.demo.echo.api.EchoService;

public class EchoServiceClient {
    private EchoService service;

    public void setService(EchoService service) {
        this.service = service;
    }

    public void initialize() {
        String clientMessage = "My Message";
        service.echoMessage(clientMessage);
    }
}
