package com.rhjensen.osgi.sample.service.one.impl;

import com.rhjensen.osgi.sample.service.one.api.ServiceOne;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

// Based on http://www.trajano.net/2012/05/developing-pom-first-osgi-bundles.html
// https://github.com/trajano/maven-jee6/tree/emerging-technologies/osgi-sample
public class ServiceOneActivator implements BundleActivator {
    private ServiceRegistration<?> serviceOneRegistration;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        final ServiceOne service = new ServiceOneImpl();
        serviceOneRegistration = bundleContext.registerService(
                ServiceOne.class.getName(), service,
                new Hashtable<String, Object>());
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        serviceOneRegistration.unregister();
    }
}
