import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/counter")
public class CounterServlet extends HttpServlet {

  Counter counter = (Counter) getServletContext().getAttribute("counter");
//  private Counter counter = new Counter();

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
    if(req.getRequestURI().equals("/counter/clear")) {
      counter.clear();
    }
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    counter.decrement(req.getIntHeader("Subtraction-Value"));
  }

}
