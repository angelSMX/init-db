package argl.io;

import org.flywaydb.core.Flyway;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/db_demo")
public class GreetingResource {

     @Inject
    Flyway flyway;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String demo() {
        return ("Hello " + flyway.info().current().getVersion().toString()+ " " + flyway.info().current().getDescription());
    }
}
