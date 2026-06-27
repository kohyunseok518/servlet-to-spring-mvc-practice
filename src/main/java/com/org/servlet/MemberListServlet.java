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

public class MemberListServlet extends HttpServlet{
    // TODO: MemberRepository.getInstance()로 저장소를 가져온다.
    private MemberRepository store = MemberRepository.getInstance();

    // TODO: GET 요청을 처리하는 doGet 메서드를 오버라이드한다.
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: memberRepository.findAll()로 회원 목록을 조회한다.
        List<Member> members = store.findAll();
        // TODO: resp.setContentType("text/html;charset=UTF-8")를 설정한다.
        resp.setContentType("text/html; charset=UTF-8");
        // TODO: resp.getWriter()로 HTML 테이블을 직접 출력한다.
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




}
