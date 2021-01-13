package com.student.servlet;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet")
public class StudentServlet extends HttpServlet {
    StudentRepository studentRepository = new StudentRepository();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method == null)
            method = "findAll";
        if(method.equals("findAll")) {
            List<Student> list = studentRepository.findAll();
            req.setAttribute("list", list);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        else if(method.equals("delete")) {
            Integer id = Integer.parseInt(req.getParameter("id"));
            studentRepository.deleteById(id);
            resp.sendRedirect("/servlet");
        }
        else if(method.equals("update")){
            Integer id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("student", studentRepository.findById(id));
            req.getRequestDispatcher("update.jsp").forward(req, resp);
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method.equals("add")) {
            Integer id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            Integer score = Integer.parseInt(req.getParameter("score"));
            studentRepository.add(id, name, score);
        }
        else if(method.equals("update")) {
            Integer id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            Integer score = Integer.parseInt(req.getParameter("score"));
            studentRepository.updateById(id, name, score);
        }
        resp.sendRedirect("/servlet");
    }
}
