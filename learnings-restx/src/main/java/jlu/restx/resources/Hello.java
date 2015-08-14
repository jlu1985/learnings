package jlu.restx.resources;

import jlu.restx.domain.Message;

import com.google.common.base.Optional;

import restx.annotations.GET;
import restx.annotations.POST;
import restx.annotations.RestxResource;
import restx.factory.Component;
import restx.security.PermitAll;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jialu
 */
@Component
@RestxResource
public class Hello {

    @PermitAll
    @GET("/hi")
    public Message sayHi(Optional<String> who) {
        return new Message().setName(who.or("guest")).setMessage("Hi");
    }

    @PermitAll
    @GET("/hi/{who}")
    public Message sayHiWithPath(String who) {
        return new Message().setName(who).setMessage("Hi");
    }

    @PermitAll
    @POST("/body")
    public Message sayHiWithBody(Message msg) {
        return msg;
    }
}
