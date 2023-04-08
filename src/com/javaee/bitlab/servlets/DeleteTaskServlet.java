package com.javaee.bitlab.servlets;

import com.javaee.bitlab.db.DBManager;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteTaskServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        DBManager.deleteTask(id);
        response.sendRedirect("/?delete_success");
    }

}
