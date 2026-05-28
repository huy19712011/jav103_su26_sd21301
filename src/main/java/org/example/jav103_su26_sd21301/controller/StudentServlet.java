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
        "/students/insert",
        "/students/delete",
        "/students/edit",
        "/students/update"
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
            case "/students/delete":
                deleteStudent(request, response);
                break;
            case "/students/edit":
                editStudent(request, response);
                break;

        }
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // load student info to the form
        // get student id from form
        Long id = Long.parseLong(request.getParameter("id"));
        // get student by id
        Student student = service.getStudentById(id);
        // send student to form
        request.setAttribute("student", student);
        // redirect to form
        request
                .getRequestDispatcher("/views/updateStudentForm.jsp")
                .forward(request, response);
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // read student info from form
        Student student = getStudentFromForm(request);

        if (student.getName() == null || student.getName().trim().isEmpty()) {
            request.setAttribute("errorMessage", "Name is required!");
            request.setAttribute("student", student);
            request.getRequestDispatcher("/views/addStudentForm.jsp").forward(request, response);
            return;
        }

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
            case "/students/update":
                updateStudent(request, response);
                break;

        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // read student info from form
        Student student = getStudentFromForm(request);

        // update student
        service.updateStudent(student);

        // redirect to list students
        response.sendRedirect(request.getContextPath() + "/students");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

        long id = Long.parseLong(request.getParameter("id"));

        service.deleteStudent(id);

        response.sendRedirect(request.getContextPath() + "/students");
    }

}