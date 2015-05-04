/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.underdog.bean.validation.test;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
@Produces({ "application/json", "application/xml" })
public class PersonResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid Person person) {
        System.out.println(person);
        return Response.ok(person).build();
    }
}
