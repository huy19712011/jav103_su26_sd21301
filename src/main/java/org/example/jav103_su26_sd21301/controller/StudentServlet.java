package org.example.jav103_su26_sd21301.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.jav103_su26_sd21301.entity.Student;
import org.example.jav103_su26_sd21301.service.StudentService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = {"/students"})
public class StudentServlet extends HttpServlet {

    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        switch (path) {
            case "/students":
                listStudents(request, response);
                break;

        }
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // data: students from DB => service => repository
        List<Student> students = service.getStudents();

        // send data to jsp file
        request.setAttribute("students", students);
        request.getRequestDispatcher("/views/studentList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}