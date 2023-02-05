
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Legin
 */
@WebServlet(name = "NoteServlet", urlPatterns = {"/NoteServlet"})
public class NoteServlet extends HttpServlet {
    
       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String mode = request.getParameter("edit");
          
          if (mode == null || mode.equals("view")){
              String path = getServletContext().getRealPath("/WEB-INF/note.txt");
         //to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title=br.readLine();
        String body=br.readLine();
        Note note = new Note(title, body);
        request.getSession().setAttribute("note", note);
        request.setAttribute("note", note);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
          } else {
              Note note = (Note) request.getSession().getAttribute("note");
              request.setAttribute("note", note);
              getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
          }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,  IOException {
        // gets inputed title and body
        String title = request.getParameter("title");
        String body = request.getParameter("body");
        Note note = (Note) request.getSession().getAttribute("note");
        note.setTitle(title);
        note.setBody(body);
        request.getSession().setAttribute("note", note);
    
    try {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, false)))) {
                out.print(note.getTitle()+"\n");
                out.print(note.getBody()+"\n");
                out.flush();
            }
            } catch (FileNotFoundException e) {
          } catch (IOException e) {
          }
          request.setAttribute("note", note);
          getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}
