package org.example.jav103_su26_sd21301.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.jav103_su26_sd21301.entity.Student;
import org.example.jav103_su26_sd21301.service.StudentService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = {
        "/students",
        "/students/new",
        "/students/insert"
})
public class StudentServlet extends HttpServlet {

    private StudentService service = new StudentService();
    private String path;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        path = request.getServletPath();
        switch (path) {
            case "/students":
                listStudents(request, response);
                break;
            case "/students/new":
                showNewForm(request, response);
                break;

        }
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // read student info from form
        Student student = getStudentFromForm(request);

        // save student to DB
        service.addStudent(student);

        // redirect to list students
        response.sendRedirect(request.getContextPath() + "/students");

    }

    private Student getStudentFromForm(HttpServletRequest request) {

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        return new Student(id, name, email, phone);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/views/addStudentForm.jsp")
                .forward(request, response);
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
        path = request.getServletPath();
        switch (path) {
            case "/students/insert":
                insertStudent(request, response);
                break;

        }
    }

}