package resource;

import dto.CounterDTO;
import entity.Counter;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/counter")
public class Resource {
  private Counter counter = Counter.COUNTER;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response get() {
    return Response.ok(new CounterDTO(counter.getCounter())).build();
  }

  @POST
  public void incrementCounter() {
    counter.increment();
  }
  @POST
  @Path("/clear")
  public void clearCounter() {
    counter.clear();
  }

  @DELETE
  public void decrement(@HeaderParam("Subtraction-Value") Integer value) {
    counter.decrement(value);

  }
}
