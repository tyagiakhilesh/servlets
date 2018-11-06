package com.akhilesh.learning.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "ServletConfigDemoServlet",
        urlPatterns = {"/servletConfig"},
        initParams = {
                @WebInitParam(name = "admin", value = "Akhilesh Tyagi"),
                @WebInitParam(name = "email", value = "abc@xyz.com")
        }
)
public class ServletConfigDemoServlet implements Servlet {
    private ServletConfig config;

    @Override
    public void init(final ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(final ServletRequest servletRequest, final ServletResponse servletResponse) throws ServletException, IOException {
        final ServletConfig servletConfig = this.getServletConfig();
        final String adminName = servletConfig.getInitParameter("admin");
        final String email = servletConfig.getInitParameter("email");
        servletResponse.setContentType("text/html");
        final PrintWriter writer = servletResponse.getWriter();
        writer.print("<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "Admin:" + adminName
                + "<br/>Email:" + email
                + "</body></html>");
    }

    @Override
    public String getServletInfo() {
        return "A Demo servlet for ServletConfig";
    }

    @Override
    public void destroy() {
        // Nothing to do here.
    }
}
