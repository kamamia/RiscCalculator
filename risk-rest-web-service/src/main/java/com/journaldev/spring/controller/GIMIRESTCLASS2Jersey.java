package com.tutorialspoint;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {

   UserDao userDao = new UserDao();

   @GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   public List<User> getUsers(){
      return userDao.getAllUsers();
   }	
}

Answer : Jersey is one of the most popular framework and API 
to develop REST based web services in Java.
Since many organization uses Jersey they check if candidate 
has used it before or not. It's simple to answer, say Yes 
if you have really used and No, if you have not. In case of 
No, you should also mention which framework you have used for developing
RESTful web services e.g. Apache CFX, Play or Restlet.

