package com.rhjensen.osgi.sample.service.one.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;
import static org.ops4j.pax.exam.CoreOptions.junitBundles;
import static org.ops4j.pax.exam.CoreOptions.options;

@RunWith(JUnit4TestRunner.class)
public class BundleTest {
    @Inject
    public BundleContext bc;

    @Configuration
    public Option[] config() {

        return options(
                junitBundles()
        );
    }

    @Test
    public void checkBundles() {
        assertNotNull(bc);
    }
}
