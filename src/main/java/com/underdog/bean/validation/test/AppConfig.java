/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.underdog.bean.validation.test;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

/**
 *
 * @author PaulSamsotha
 */
@ApplicationPath("/api")
public class AppConfig extends ResourceConfig {

    public AppConfig() {
        System.out.println("==== Creating AppConfig ====");
        //System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        packages("com.underdog.bean.validation.test");
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
//        /property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
        //property(CommonProperties.FEATURE_AUTO_DISCOVERY_DISABLE, true);
        //property(ServerProperties.FEATURE_AUTO_DISCOVERY_DISABLE, true);
        //property(ServerProperties.BV_FEATURE_DISABLE, true);
        register(ValidationConfigurationContextResolver.class);

    }
}
