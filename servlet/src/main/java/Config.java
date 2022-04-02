import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Config  implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    sce.getServletContext().setAttribute("counter", new Counter());
  }
}
