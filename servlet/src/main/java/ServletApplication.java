import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlet.FilterMapping;
import org.eclipse.jetty.servlet.ListenerHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletMapping;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.webapp.WebAppContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;


public class ServletApplication {

  public static void main(String[] args) throws Exception{
    // run, Jetty, run!
    int port = 8081;
    Server server = createServer(port);
    server.start();
    server.join();

  }

  private static Server createServer(int port) {
    Server server = new Server(port);
    ServletHandler handler = new ServletHandler();
    handler.addServletWithMapping(CounterServlet.class, "/counter");
    handler.addServletWithMapping(CounterServlet.class, "/counter/clear");
    server.setHandler(handler);
    return server;
  }
}
