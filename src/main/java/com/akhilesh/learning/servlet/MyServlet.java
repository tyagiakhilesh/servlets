package com.akhilesh.learning.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet", urlPatterns = {"/my"})
public class MyServlet implements Servlet {
    private transient ServletConfig servletConfig;

    @Override
    public void init(final ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public void service(final ServletRequest servletRequest, final ServletResponse servletResponse) throws IOException {
        final String servletName = this.getServletInfo();
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("<!DOCTYPE html>"
                + "<html>"
                + "<body>Hello from " + servletName
                + "</body>"
                + "</html>");
    }

    @Override
    public String getServletInfo() {
        return "Hey.. This is my first servlet!";
    }

    @Override
    public void destroy() {
        //DO nothing. We have nothing to manage yet.
    }
}
