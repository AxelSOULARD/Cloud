package src.main;

import java.io.*;

import javax.servlet.*;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/home"}
)
public class AppEngine {
    
    @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    response.getWriter().print("Hello App Engine!\r\n");

  }
}

}
