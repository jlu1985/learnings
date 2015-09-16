package jlu.shop.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import jlu.shop.domain.JsonBean;

@Path("/json")
public class JsonResource {

	@GET
	@Produces("application/json")
	public JsonBean getDefaultBean() {
		JsonBean b = new JsonBean();
		b.setId(9983);
		b.setMessage("Hello Jersey!");
		return b;
	}
}
