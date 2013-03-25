package com.rhjensen.osgi.sample.service.one;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.rhjensen.osgi.sample.service.one.api.ServiceOne;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.CoreOptions;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import javax.inject.Inject;
import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.ops4j.pax.exam.CoreOptions.*;

@RunWith(JUnit4TestRunner.class)
public class ServiceOneBundleTest {
    @Inject
    public BundleContext bc;

    @Configuration
    public Option[] config() {
        // Had an error saying no method found related to the google collections stuff,
        // and found a StackOverflow entry
        // http://stackoverflow.com/questions/15067691/osgi-integration-testing-pax-exam-probe-executing-tests-before-container-bundle
        String pathToTestClass = ServiceOneBundleTest.class.getClassLoader().getResource(".").getPath();
        String[] pathParts = pathToTestClass.split("OsgiBundleTest");
        StringBuilder pathToBundle = new StringBuilder(pathParts[0]);
        pathToBundle.append("ServiceOneModule/target/ServiceOneModule-1.0-SNAPSHOT.jar");
        return CoreOptions.options(
                mavenBundle("com.google.guava", "guava", "13.0.1").startLevel(30),
                bundle(new File(pathToBundle.toString()).toURI().toString()),
                junitBundles()
        );
    }

    @Test
    public void shouldLoadServiceOneBundle() {
        boolean found = Iterables.any(Arrays.asList(bc.getBundles()), new Predicate<Bundle>() {

            @Override
            public boolean apply(Bundle bundle) {
                System.out.println("Found " + bundle.getSymbolicName());
                return bundle.getSymbolicName().contains("ServiceOneModule");
            }
        });
        assertTrue("We did not find ServiceOneModule in loaded bundles", found);
    }

    @Test
    public void shouldBeAbleToCallGreetingInServiceOne() {
        ServiceReference<ServiceOne> serviceReference = bc.getServiceReference(com.rhjensen.osgi.sample.service.one.api.ServiceOne.class);
        ServiceOne myService = null;
        if (serviceReference != null) {
            myService = bc.getService(serviceReference);
        }
        assertNotNull("Did not find ServiceOne", myService);
        assertTrue("Hello World!".equals(myService.greeting()));
    }

}
