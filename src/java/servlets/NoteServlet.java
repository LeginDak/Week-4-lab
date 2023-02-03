
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Legin
 */
@WebServlet(name = "NoteServlet", urlPatterns = {"/NoteServlet"})
public class NoteServlet extends HttpServlet {
    
       @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/viewnot.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request,)
}
