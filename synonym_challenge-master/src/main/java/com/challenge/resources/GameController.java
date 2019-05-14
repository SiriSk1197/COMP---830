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
import com.challenge.entity.Game;
import com.challenge.manager.GameServices;
import com.challenge.request.RequestContext;



@Path("/game")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameController {

    @Context
    private HttpServletRequest httpServletRequest;

    private static Logger logger = LoggerFactory.getLogger(GameController.class);

    @Inject
    GameServices gameServicesImpl;

    // post a game
    @POST
    public Response addGame(Game game, @Context UriInfo uriInfo) {
        Response response = null;
        RequestContext requestContext = (RequestContext) httpServletRequest.getAttribute(RequestConstants.REQUEST_CONTEXT);
        logger.info("inside create item request with" + requestContext);
        try {
            response = Response.status(Response.Status.CREATED)
                    .entity(gameServicesImpl
                            .add(game)).build();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("exception occurred in addGame", e);
        }
        logger.info("Time taken by addGame request::" + (System.currentTimeMillis() - requestContext.getInTime()));
        return response;
    }

    //update a game
    @PUT
    @Path("{id}")
    public Response updateGame(Game game,
                                  @PathParam("id") Integer gameId, @Context UriInfo uriInfo) {
        Response response = null;
        try {
            response = Response.status(Response.Status.OK)
                    .entity(gameServicesImpl.update(
                            game, gameId)).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    // Get game
    @GET
    @Path("{id}")
    public Response getGame(@PathParam("id") Integer id) throws Exception {
        Response response = null;
        try {
            response = Response.status(Response.Status.OK)
                    .entity(gameServicesImpl.getGame(id)).build();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    // Get List of All the games
    @GET
    public Response getGames() {
        List<Game> gameList = null;
        Response response = null;
        try {
        	gameList = gameServicesImpl.getGames();
            
            response = Response.status(Response.Status.OK).entity(gameList)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

}
