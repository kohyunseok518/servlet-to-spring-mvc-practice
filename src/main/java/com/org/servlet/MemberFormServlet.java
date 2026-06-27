package com.org.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MemberFormServlet extends HttpServlet {

    // GET 요청을 처리하는 doGet
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String contextPath = req.getContextPath();

        PrintWriter writer = resp.getWriter();
        writer.println("<form action=\"" + contextPath + "/members\" method=\"post\">\n" +
                "    username: <input type=\"text\" name=\"username\">\n" +
                "    age: <input type=\"text\" name=\"age\">\n" +
                "    <button type=\"submit\">전송</button>\n" +
                "</form>");
    }
}
