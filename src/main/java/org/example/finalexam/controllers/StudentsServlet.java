package org.example.finalexam.controllers;

import org.example.finalexam.models.Student;
import org.example.finalexam.services.StudentsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "studentsServlet", value = "/student")
public class StudentsServlet extends HttpServlet {
    StudentsService studentsService = new StudentsService();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String getAction = request.getParameter("action");
        if (getAction == null) getAction = "";
        switch (getAction) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            default:
                showListPage(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentsService.delete(id);
        response.sendRedirect("/student");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/edit.jsp");
        int findId = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("editStudent", studentsService.findById(findId));
        requestDispatcher.forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/create.jsp");
        requestDispatcher.forward(request,response);
    }
    private void showListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/students.jsp");
        List<Student> students = studentsService.showAll();
        request.setAttribute("studentList", students);
        requestDispatcher.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postAction = req.getParameter("action");
        if (postAction == null) postAction = "";
        switch (postAction) {
            case "create":
                createStudent(req, resp);
                break;
            case "edit":
                editStudent(req,resp);
                break;
        }
    }

    private void editStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int editId = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        double gpa = Double.parseDouble(req.getParameter("gpa"));
        studentsService.update(editId, new Student(editId,name,age,gender,gpa));
        resp.sendRedirect("/student");
    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int newId = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        double gpa = Double.parseDouble(req.getParameter("gpa"));
        studentsService.create(new Student(newId, name, age, gender, gpa));
        resp.sendRedirect("/student");
    }
}