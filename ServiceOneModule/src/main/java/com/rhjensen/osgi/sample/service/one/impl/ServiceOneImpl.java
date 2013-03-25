package com.rhjensen.osgi.sample.service.one.impl;

import com.rhjensen.osgi.sample.service.one.api.ServiceOne;

public class ServiceOneImpl implements ServiceOne {
     public String greeting() {
         return "Hello World!";
     }
}
