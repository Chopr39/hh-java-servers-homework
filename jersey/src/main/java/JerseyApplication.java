import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import resource.Resource;

import javax.ws.rs.core.Application;
import java.util.Set;

public class JerseyApplication extends Application{
  @Override
  public Set<Class<?>> getClasses() {
    return Set.of(Resource.class);
  }

  public static void main(String[] args) throws Exception {
    // run, Jetty, run!
    int port = 8081;
    Server server = new Server(port);
    server.setHandler(getJerseyHandler());
    server.start();
    server.join();
  }

  private static Handler getJerseyHandler() {
    ServletContextHandler handler = new ServletContextHandler();
    ServletHolder holder = handler.addServlet(ServletContainer.class, "/*");
    holder.setInitOrder(1);
    holder.setInitParameter("javax.ws.rs.Application", "JerseyApplication");

    return handler;
  }
}
