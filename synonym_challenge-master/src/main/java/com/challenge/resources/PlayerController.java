package com.challenge.resources;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.challenge.constants.RequestConstants;
import com.challenge.entity.Player;
import com.challenge.manager.PlayerServices;
import com.challenge.request.RequestContext;



@Path("/players")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayerController {

    @Context
    private HttpServletRequest httpServletRequest;

    private static Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @Inject
    PlayerServices playerServicesImpl;

    // post a player
    @POST
    public Response addPlayer(Player player, @Context UriInfo uriInfo) {
        Response response = null;
        RequestContext requestContext = (RequestContext) httpServletRequest.getAttribute(RequestConstants.REQUEST_CONTEXT);
        logger.info("inside create item request with" + requestContext);
        try {
            response = Response.status(Response.Status.CREATED)
                    .entity(playerServicesImpl
                            .add(player)).build();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("exception occurred in addPlayer", e);
        }
        logger.info("Time taken by addPlayer request::" + (System.currentTimeMillis() - requestContext.getInTime()));
        return response;
    }

    //update a player
    @PUT
    @Path("{id}")
    public Response updatePlayer(Player player,
                                  @PathParam("id") Integer playerId, @Context UriInfo uriInfo) {
        Response response = null;
        try {
            response = Response.status(Response.Status.OK)
                    .entity(playerServicesImpl.update(
                            player, playerId)).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    // Get product
    @GET
    @Path("{id}")
    public Response getPlayer(@PathParam("id") Integer id) throws Exception {
        Response response = null;
        try {
            response = Response.status(Response.Status.OK)
                    .entity(playerServicesImpl.getPlayer(id)).build();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    // Get List of All the players
    @GET
    public Response getPlayers() {
        List<Player> playerList = null;
        Response response = null;
        try {
        	playerList = playerServicesImpl.getPlayers();
            
            response = Response.status(Response.Status.OK).entity(playerList)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
    
    @GET
    @Path("/username/{userId}/password/{pswd}")
    public Response getPlayerDetails(@PathParam("userId") String userId,
    		@PathParam("pswd") String pswd) throws Exception  {
    	 Response response = null;
         try {
             response = Response.status(Response.Status.OK)
                     .entity(playerServicesImpl.getPlayer(userId,pswd)).build();
         } catch (Exception e) {
             e.printStackTrace();
             throw e;
         }
         return response;
    }

}
