package jlu.shop.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/services")
public class ShoppingApplication extends ResourceConfig {
	public ShoppingApplication() {
		packages("jlu.shop.services");
		register(JacksonFeature.class);
	}
}
