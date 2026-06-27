package com.org.servlet;

import com.org.domain.Member;
import com.org.repository.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MemberServlet extends HttpServlet {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("<a href=\"" + req.getContextPath() + "/members/new\">회원 등록</a>");
        writer.println("<table>");
        writer.println("    <thead>");
        writer.println("    <tr>");
        writer.println("        <th>id</th>");
        writer.println("        <th>username</th>");
        writer.println("        <th>age</th>");
        writer.println("    </tr>");
        writer.println("    </thead>");
        writer.println("    <tbody>");

        for (Member member : members) {
            writer.println("    <tr>");
            writer.println("        <td>" + member.getId() + "</td>");
            writer.println("        <td>" + member.getUsername() + "</td>");
            writer.println("        <td>" + member.getAge() + "</td>");
            writer.println("    </tr>");
        }

        writer.println("    </tbody>");
        writer.println("</table>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 요청으로 받은 파라미터를 꺼냄
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        // 해당 파라미터로 member 생성
        Member member = new Member(username, age);
        // 저장소에 저장
        memberRepository.save(member);
        resp.setContentType("text/html;charset=UTF-8");

//        // HTML로 저장 결과 화면 직접 응답
//        PrintWriter writer = resp.getWriter();
//        writer.println("<html>");
//        writer.println("<body>");
//        writer.println("성공");
//        writer.println("<ul>");
//        writer.println("    <li>id=" + member.getId() + "</li>");
//        writer.println("    <li>username=" + member.getUsername() + "</li>");
//        writer.println("    <li>age=" + member.getAge() + "</li>");
//        writer.println("</ul>");
//        writer.println("<a href=\"" + req.getContextPath() + "/members/new\">다시 등록</a>");
//        writer.println("</body>");
//        writer.println("</html>");

        resp.sendRedirect(req.getContextPath() + "/members");
    }
}
