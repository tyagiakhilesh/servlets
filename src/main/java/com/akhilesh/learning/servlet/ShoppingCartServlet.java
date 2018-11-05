package com.akhilesh.learning.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShoppingCartServlet", urlPatterns = "/shop")
public class ShoppingCartServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.printf("Hello");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.print("<HTML><HEAD><TITLE>Online Shop</TITLE>" +
                "</HEAD><BODY><FORM METHOD=POST>" +
                "<INPUT TYPE=SUBMIT NAME=foo VALUE=" +
                "\"Put a FOO into the shopping cart\">" +
                "<INPUT TYPE=SUBMIT NAME=bar VALUE=" +
                "\"Put a BAR into the shopping cart\">" +
                "<INPUT TYPE=SUBMIT NAME=see VALUE=" +
                "\"See the shopping cart contents\">" +
                "<INPUT TYPE=SUBMIT NAME=buy VALUE=" +
                "\"Buy the shopping cart contents\">" +
                "</FORM></BODY></HTML>");
        out.close();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String msg;

        HttpSession session = req.getSession(true);
        if (session.isNew()) {
            session.setAttribute("foo", new int[]{0});
            session.setAttribute("bar", new int[]{0});
        }

        int[] foo = (int[]) session.getAttribute("foo");
        int[] bar = (int[]) session.getAttribute("bar");

        if (req.getParameter("foo") != null) {
            foo[0]++;
            msg = "Bought a FOO. You now have " + foo[0] + ".";
        } else if (req.getParameter("bar") != null) {
            bar[0]++;
            msg = "Bought a BAR. You now have " + bar[0] + ".";
        } else if (req.getParameter("buy") != null) {
            session.invalidate();
            msg = "Your order for " + foo[0] + " FOOs and " + bar[0] +
                    " BARs has been accepted. Your shopping cart is empty now.";
        } else {
            msg = "You have " + foo[0] + " FOOs and " + bar[0] +
                    " BARs in your shopping cart.";
        }

        res.setContentType("text/html");
        res.setHeader("pragma", "no-cache");
        PrintWriter out = res.getWriter();
        out.print("<HTML><HEAD><TITLE>Shopping Cart</TITLE></HEAD><BODY>");
        out.print(msg);
        out.print("<HR><A HREF=\"");
        out.print(req.getRequestURI());
        out.print("\">Back to the shop</A></BODY></HTML>");
        out.close();
    }

    public String getServletInfo() {
        return "ShoppingCartServlet 1.0 by Stefan Zeiger";
    }
}
