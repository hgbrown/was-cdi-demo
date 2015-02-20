package za.co.hbrown.boundary;

import za.co.hbrown.controller.ClientService;
import za.co.hbrown.entity.Client;
import za.co.hbrown.qualifiers.Production;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Iterator;

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
    @Production
    ClientService clientService;

    @Inject
    @Any
    Instance<ClientService> clientServiceInstance;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.printf("clientService=[%s]%n", clientService);
        if(clientServiceInstance != null) {
            System.out.printf("isUnsatisfied=[%s] isAmbiguous=[%s]%n",
                    clientServiceInstance.isUnsatisfied(), clientServiceInstance.isAmbiguous());
            final Iterator<ClientService> it = clientServiceInstance.iterator();
            while (it.hasNext()) {
                final ClientService service = it.next();
                System.out.printf("service=[%s]%n", service.getClass().getName());
            }
        } else {
            System.out.printf("clientServiceInstance=[%s]%n", clientServiceInstance);
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        final Client client = clientService.get(id);
        final Client client = new Client(id, "Henry " + id);
        return Response.ok(client).build();
    }

}
