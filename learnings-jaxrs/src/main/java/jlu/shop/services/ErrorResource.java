package jlu.shop.services;

import java.net.URI;
import java.nio.file.attribute.AclEntry.Builder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/error")
public class ErrorResource {

	@GET
	@Path("404")
	public Response notFound() {
		return Response.status(404).build();
	}

	@GET
	@Path("500")
	public Response internalError() {
		return Response.status(500).build();
	}

	@GET
	@Path("201")
	public Response created() {
		return Response.created(URI.create("http://localhost:8080/services/error/500")).build();
	}

}
