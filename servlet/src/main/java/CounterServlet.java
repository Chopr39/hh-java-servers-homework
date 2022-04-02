import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class CounterServlet extends HttpServlet {

  private Counter counter = Counter.COUNTER;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(req.getRequestURI().equals("/counter")) {
      PrintWriter writer = resp.getWriter();
      writer.print("<h1>Counter: " + counter.getCounter() + "</h1>");
      writer.flush();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(req.getRequestURI().equals("/counter")) {
      counter.increment();
    }
    if(req.getRequestURI().equals("/counter/clear") && cookieIsOk(req)) {
      counter.clear();
    }
  }

  private boolean cookieIsOk(HttpServletRequest req) {
    Cookie[] cookie = req.getCookies();
    if (cookie != null) {
      return Arrays.stream(cookie)
          .filter(c -> c.getName().equals("hh-auth"))
          .anyMatch(c -> c.getValue().length() > 10);
    }
    return false;
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    counter.decrement(req.getIntHeader("Subtraction-Value"));
  }

}
