package jlu.shop.providers;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;

@Provider
public class MyProvider implements ContextResolver<ObjectMapper> {

	final ObjectMapper defaultObjectMapper;
	
	public MyProvider(){
		defaultObjectMapper = new ObjectMapper();
	}
	@Override
	public ObjectMapper getContext(Class<?> arg0) {
		return defaultObjectMapper;
	}

}
