/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.underdog.bean.validation.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.grizzly.GrizzlyTestContainerFactory;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.junit.Test;

public class SimpleValidationTest extends JerseyTest {
    
    public SimpleValidationTest() {
        //super(new GrizzlyWebTestContainerFactory());
    }
    
    /*
    @Override
    public DeploymentContext configureDeployment() {
        return ServletDeploymentContext.forServlet(new ServletContainer(new AppConfig()))
                .build();
    }*/
    
    
    @Override
    public Application configure() {
        return new AppConfig();
    }
    
    @Test
    public void doTest()throws Exception  {
        
        client().register(JacksonFeature.class);
        Person person = new Person();
        person.setId(1);
        person.setName("peeskillet");
        person.setPhone("1234567890000");
        person.setEmail("hello@world.com");
        
        
        Response response = target("person").request()
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(person));
        System.out.println(response.readEntity(String.class));
    }
    
}
