package com.akhilesh.learning.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WelcomeServlet", urlPatterns = {"/welcome"}, displayName = "Welcome!!", asyncSupported = true)
public class WelcomeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.processRequest(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.processRequest(req, resp);
    }

    private void processRequest(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WelcomeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WelcomeServlet at " + req.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
