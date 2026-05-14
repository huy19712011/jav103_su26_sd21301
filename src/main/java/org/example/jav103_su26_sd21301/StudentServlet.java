package org.example.jav103_su26_sd21301;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*
       response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("The student is: " + request.getParameter("firstName") + " " + request.getParameter("lastName"));
        out.println("<br>");
        out.println("From: " + request.getParameter("country"));

        String[] favoriteLanguages = request.getParameterValues("favoriteLang");
        out.println("<br>");
        out.println("Favorite Languages:");
        out.println("<br>");
        for (String lang : favoriteLanguages) {

            out.println(lang);
            out.println("<br>");
        }
        out.println("</body><html>");
*/

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String country = request.getParameter("country");

        String[] favoriteLangs = request.getParameterValues("favoriteLang");

        // send data to view
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("country", country);
        request.setAttribute("favoriteLangs", favoriteLangs);


        // get request dispatcher
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/student.jsp");

        // forward request to JSP
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}