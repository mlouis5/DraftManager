/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager;

//import com.sun.jersey.api.client.Client;
import java.util.Optional;
import javax.ws.rs.client.Client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author Mac
 */
public interface ServiceRequestor {

//    default ClientResponse makePostRequest(String resourcePath, String jsonEncodedString,
//            MediaType consumeType, MediaType acceptType) {
//        Client client = ClientBuilder.newClient();//Client.create();
//        WebTarget target = client.target(resourcePath);
//        //WebResource resource = client.resource(resourcePath);
//
//        ClientResponse response = target.request(consumeType).accept(acceptType).po
//                resource.type(consumeType)
//                .accept(acceptType)
//                .post(ClientResponse.class, jsonEncodedString);
//
//        return response;
//    }

    default Response makeGetRequest(String resourcePath, MediaType acceptType) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(resourcePath);

        Response response = target.request(acceptType).get(Response.class);

        return response;
    }
    
    default Response makeGetRequest(String resourceBasePath, String resourcePath, MediaType acceptType) {
        Client client = ClientBuilder.newClient();
        //WebTarget target = client.target(resourceBasePath).path(resourcePath);
        WebTarget target = client.target(resourceBasePath);//.path(Optional.ofNullable(resourcePath).orElse(""));

        Response response = target.request(acceptType).get(Response.class);

        return response;
    }

//    default Response makeGetRequest(String resourcePath, MediaType acceptType, ClientConfig cfg) {
//        Client client = Client.create(cfg);
//        WebResource resource = client.resource(resourcePath);
//
//        Response response = resource
//                .accept(acceptType).get(Response.class);
//
//        return response;
//    }
    
    default Response makeGetRequest(String resourceBasePath, String resourcePath, MediaType acceptType, ClientConfig cfg) {
        Client client = ClientBuilder.newClient(cfg);
        
        WebTarget target = client.target(resourceBasePath).path(Optional.ofNullable(resourcePath).orElse(""));

        Response response = target.request(acceptType).get(Response.class);

        return response;
    }
    
    default Object makeGetRequest(String resourceBasePath, String resourcePath, Class<?> returnType, MediaType acceptType, ClientConfig cfg) {
        Client client = ClientBuilder.newClient(cfg);
        
        WebTarget target = client.target(resourceBasePath).path(Optional.ofNullable(resourcePath).orElse(""));

        Object requested = target.request(acceptType).get(returnType);

        return requested;
    }
    
    default Object makeGetRequest(String resourceBasePath, String resourcePath, GenericType<? extends Object> returnType, MediaType acceptType, ClientConfig cfg) {
        Client client = ClientBuilder.newClient(cfg);        
        WebTarget target = client.target(resourceBasePath).path(Optional.ofNullable(resourcePath).orElse(""));        
        Object requested = target.request(acceptType).get(returnType);
        return requested;
    }
}
