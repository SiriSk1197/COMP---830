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
import com.challenge.entity.Dictionary;
import com.challenge.manager.DictionaryServices;
import com.challenge.request.RequestContext;



@Path("/api/dictionary")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DictionaryController {

    @Context
    private HttpServletRequest httpServletRequest;

    private static Logger logger = LoggerFactory.getLogger(DictionaryController.class);

    @Inject
    DictionaryServices dictionaryServicesImpl;

    // post a dictionary
    @POST
    public Response addDictionary(Dictionary dictionary, @Context UriInfo uriInfo) {
        Response response = null;
        RequestContext requestContext = (RequestContext) httpServletRequest.getAttribute(RequestConstants.REQUEST_CONTEXT);
        logger.info("inside create item request with" + requestContext);
        try {
            response = Response.status(Response.Status.CREATED)
                    .entity(dictionaryServicesImpl
                            .add(dictionary)).build();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("exception occurred in addDictionary", e);
        }
        logger.info("Time taken by addDictionary request::" + (System.currentTimeMillis() - requestContext.getInTime()));
        return response;
    }

    //update a dictionary
    @PUT
    @Path("{id}")
    public Response updateDictionary(Dictionary dictionary,
                                  @PathParam("id") Integer dictionaryId, @Context UriInfo uriInfo) {
        Response response = null;
        try {
            response = Response.status(Response.Status.OK)
                    .entity(dictionaryServicesImpl.update(
                            dictionary, dictionaryId)).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    // Get product
    @GET
    @Path("{id}")
    public Response getDictionary(@PathParam("id") Integer id) throws Exception {
        Response response = null;
        try {
            response = Response.status(Response.Status.OK)
                    .entity(dictionaryServicesImpl.getDictionary(id)).build();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    // Get List of All the dictionary
    @GET
    public Response getDictionarys() {
        List<Dictionary> dictionaryList = null;
        Response response = null;
        try {
        	dictionaryList = dictionaryServicesImpl.getDictionary();
            
            response = Response.status(Response.Status.OK).entity(dictionaryList)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

}
