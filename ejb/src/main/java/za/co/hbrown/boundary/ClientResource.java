package za.co.hbrown.boundary;

import za.co.hbrown.controller.ClientService;
import za.co.hbrown.entity.Client;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA by henryb.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201502191326
 * @since 0.1201502191326
 */
@Path("/client")
public class ClientResource {

    @Inject
    ClientService clientService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        final Client client = clientService.get(id);
//        final Client client = new Client(id, "Henry " + id);
        return Response.ok(client).build();
    }

}
