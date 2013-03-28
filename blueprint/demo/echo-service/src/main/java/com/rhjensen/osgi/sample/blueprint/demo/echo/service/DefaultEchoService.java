package com.rhjensen.osgi.sample.blueprint.demo.echo.service;

import com.rhjensen.osgi.sample.blueprint.demo.echo.api.EchoService;

import java.io.PrintStream;

/**
 * User: rjensen
 * Date: 3/28/13
 * Time: 12:27 PM
 */
public class DefaultEchoService implements EchoService {
    private PrintStream outputStream;

    @Override
    public void echoMessage(String message) {
        StringBuffer massaged = new StringBuffer(message);
        massaged.reverse();
        outputStream.println(massaged.toString());
    }

    @Override
    public void initialize() {
        if (outputStream == null) {
            outputStream = System.out;
        }
        outputStream.println(this.getClass().getName() + " is initialized.");
    }

    public void setOutputStream(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    public PrintStream getOutputStream() {
        return outputStream;
    }
}
