package com.test.service;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/TestService")
public class TestService2 {

   UserDao userDao = new UserDao();

   @GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   public List<User> getUsers(){
      return userDao.getAllUsers();
   }	
   
 //@GET
   //@Path("/{parameter}")
   public Response responseMsg( @PathParam("parameter") String parameter,
           @DefaultValue("Nothing to say") @QueryParam("value") String value) {

       String output = "Hello from: " + parameter + " : " + value;

       return Response.status(200).entity(output).build();

   }
}