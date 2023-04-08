package com.javaee.bitlab.servlets;

import com.javaee.bitlab.db.DBManager;
import com.javaee.bitlab.db.models.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/")
public class HomeServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String deadline = request.getParameter("deadline");
        DBManager.addTask(new Task(1L, name, description, deadline));
        response.sendRedirect("/?success");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        ArrayList<Task> tasks = DBManager.getTasks();
        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }


}
