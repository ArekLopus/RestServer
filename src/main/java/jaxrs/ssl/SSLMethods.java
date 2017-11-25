package jaxrs.ssl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ssl")
public class SSLMethods {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response getTest() {
		String str = "Connected over SSL!";
		return Response.ok(str).build();
	}
	
	
	
}
