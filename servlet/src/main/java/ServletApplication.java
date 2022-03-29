import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;




public class ServletApplication {

  public static void main(String[] args) throws Exception{
    // run, Jetty, run!
    int port = 8081;
    Server server = createServer(8081);
    server.start();
    server.join();

  }

  private static Server createServer(int port) {
    Server server = new Server(port);
    ServletHandler handler = new ServletHandler();
    handler.addServletWithMapping(Counter.class, "/counter");
    server.setHandler(handler);
    return server;
  }
}
