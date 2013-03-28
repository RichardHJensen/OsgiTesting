package com.rhjensen.osgi.sample.blueprint.demo.echo.api;

// Using apache aries (blueprint) to create an OSGi application
// Sample based on http://www.ibm.com/developerworks/library/wa-aries
public interface EchoService {
    public void echoMessage(String message);

    public void initialize();
}
